package coding.buffer;

import org.junit.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * 词频计算
 *
 * @author zzf
 * @date 2022/10/14 5:14 下午
 */
public class WordCount {
    final ForkJoinPool pool = new ForkJoinPool();

    /**
     * 单线程
     *
     * @throws IOException
     */
    @Test
    public void compare_with_single() throws IOException {
        BufferedInputStream word = new BufferedInputStream(new FileInputStream("word"));
        byte[] bytes = new byte[1024 * 4];
        int len = 0;
        HashMap<String, Integer> total = new HashMap<>();
        while ((len = word.read(bytes)) != -1) {
            byte[] bytes1 = Arrays.copyOfRange(bytes, 0, len);
            String s = new String(bytes1);
            HashMap<String, Integer> hashMap = countByString(s);
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                incKey(entry.getKey(), total, entry.getValue());
            }
        }
    }

    private static HashMap<String, Integer> countByString(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String s = stringTokenizer.nextToken();
            incKey(s, map, 1);
        }
        return map;
    }

    private static void incKey(String key, HashMap<String, Integer> map, Integer n) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + n);
        } else {
            map.put(key, n);
        }
    }

    /**
     * 多线程
     */
    @Test
    public void count() throws ExecutionException, InterruptedException {
        WordCount wordCount = new WordCount();
        wordCount.run("word", 1024 * 4);
    }

    class CountTask implements Callable<HashMap<String, Integer>> {
        private final long start;
        private final long end;
        private final String fileName;

        CountTask(long start, long end, String fileName) {
            this.start = start;
            this.end = end;
            this.fileName = fileName;
        }

        @Override
        public HashMap<String, Integer> call() throws Exception {
            FileChannel channel = new RandomAccessFile(this.fileName, "rw").getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, this.start, this.end - this.start);
            String s = StandardCharsets.US_ASCII.decode(buffer).toString();
            return countByString(s);
        }
    }

    /**
     * @param fileName
     * @param chunkSize 分块大小
     */
    public void run(String fileName, long chunkSize) throws ExecutionException, InterruptedException {
        File file = new File(fileName);
        long fileSize = file.length();
        long position = 0;
        ArrayList<ForkJoinTask<HashMap<String, Integer>>> tasks = new ArrayList<>();
        while (position < fileSize) {
            long next = Math.min(position + chunkSize, fileSize);
            CountTask task = new CountTask(position, next, fileName);
            position = next;
            ForkJoinTask<HashMap<String, Integer>> future = pool.submit(task);
            tasks.add(future);
        }
        HashMap<String, Integer> total = new HashMap<>();
        for (ForkJoinTask<HashMap<String, Integer>> future : tasks) {
            HashMap<String, Integer> map = future.get();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                incKey(entry.getKey(), total, entry.getValue());
            }
        }
    }
}
