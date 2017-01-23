import org.apache.poi.util.StringUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by GetFire on 23.01.2017.
 */
public class CreateTXTv1 {
    public static void main(String[] args){
        Map<Integer, String> excelFile = new HashMap<>();
        Map<Integer, String> resourcecFile = new HashMap<>();
        List<String> neededLines = new ArrayList<>();
        BufferedReader br = null;
        BufferedReader br1 = null;
        BufferedWriter bw = null;
        String line1;
        String line2;
        StringBuilder sB = new StringBuilder();
        StringBuilder content = new StringBuilder();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\practice\\Papa\\src\\new1.txt"), Charset.forName("UTF-8")));
            br1 = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\practice\\Papa\\src\\Ресурс.txt"), Charset.forName("UTF-8")));
            Integer i = 0;
            while ((line1 = br.readLine()) != null) {
                excelFile.put(i, line1);
                i++;
            }
            Integer j = 0;

            while ((line2 = br1.readLine()) != null) {
                resourcecFile.put(j, line2);
                j++;
            }
            for (String s : excelFile.values()) {
                List<String> d = Arrays.asList(s.split("\t"));
                if (!d.contains("name")) {
                    for (String s1 : resourcecFile.values()) {
                        List<String> b = Arrays.asList(s1.split(", "));
                        if (b.contains(d.get(1))) {
                            List<String> c = b.stream().filter(a -> !a.equals(d.get(1))).collect(Collectors.toList());

                            String[] v = c.toArray(new String[c.size()]);
                            String g = StringUtil.join(v, ", "); //готовая строка, что мне нужна
                            neededLines.add(g);
                            sB.append(d.get(0));
                            sB.append("\t");
                            sB.append(d.get(1));
                            sB.append("\t");
                            sB.append(d.get(2));
                            sB.append("\t");
                            sB.append("||");
                            sB.append(g);
                            sB.append("\n");
                            String cov = sB.toString();
                            content.append(cov);
                            sB.delete(0, sB.length());
                        }
                    }
                }
            }
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\practice\\Papa\\src\\Final1.txt"), Charset.forName("UTF-8")));
            bw.write(content.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (br!=null)
                    br.close();
                if (br1!=null)
                    br.close();
                if (bw!=null)
                    bw.close();
            }catch (IOException ex){
                System.out.println(ex.getClass().getSimpleName()+": "+ ex.getMessage());
            }
        }
    }
}

