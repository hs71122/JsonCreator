package org.example;

import com.google.gson.Gson;
import org.example.model.Data;
import org.example.model.Link;
import org.example.model.Node;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        int length = 1000;
        Set<Node> nodes = new HashSet<>();
        List<Link> links = new ArrayList<>();
        for(int i = 0;  i <= length; i++){
            nodes.add(new Node(String.valueOf(i),"node_"+i,String.valueOf(i)));
            Random random = new Random();
            int rInt = random.nextInt(20)+1;
            for (int j = 0; j < rInt; j++ ){
                String curNode = i+"."+j;
                nodes.add(new Node(curNode,"node_"+curNode,curNode));
                links.add(new Link(String.valueOf(i),curNode));
                if (j %4 == 0){
                    links.add(new Link(curNode,String.valueOf(i)));
                }
            }
            if (i > 1){
                links.add(new Link(String.valueOf(i),String.valueOf(random.nextInt(i))));
            }

            if (i == 50){
                writeTiFile(new Data(nodes,links),"data_sm.json");
            } else if (i  == length/2){
                writeTiFile(new Data(nodes,links),"data_md.json");
            } else if (i  == length) {
                writeTiFile(new Data(nodes,links),"data_lg.json");
            }
        }
    }
    public static void writeTiFile(Data data,String fileName){
        Gson gson = new Gson();
        System.out.println("Writing nodes:"+data.getNodes().size()+" links:"+data.getLinks().size());
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
