import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};

        System.out.println(longestStrChain(words));

    }

    public static int longestStrChain(String[] words) {
        if(words.length == 0){
            return 0;
        }
        Map<Integer, Set<String>> sizeMap = new TreeMap<>((obj1, obj2)-> Integer.compare(obj2,obj1));
        Graph g = new Graph();
        for(String word : words){
            Set<String> set = sizeMap.getOrDefault(word.length(), new HashSet<String>());
            set.add(word);
            sizeMap.put(word.length(), set);
        }
        List<Set<String>> allMapValues = new ArrayList<>(sizeMap.values());
        for(int i = 0; i<allMapValues.size()-1; i++){
            //add the edges
            Set<String> nextSet = allMapValues.get(i+1);
            for(String str : allMapValues.get(i)){
                for(int strIndex = 0; strIndex<str.length(); strIndex++){
                    String newString = (strIndex == 0)? str.substring(strIndex+1): str.substring(0, strIndex) + str.substring(strIndex+1);
                    if(nextSet.contains(newString)){
                        g.addEdge(str, newString);
                    }
                }
            }
        }

        Set<String> visited = new HashSet<String>();
        int maxLen = 0;
        for(int i = 0; i<allMapValues.size(); i++){
            for(String str:allMapValues.get(i)){
                if(!visited.contains(str)){
                    maxLen = Math.max(maxLen, g.getMaxLength(str, visited));
                }
            }
        }
        return (maxLen == 0)? 1 : maxLen;
    }

    static class Graph{
        HashMap<String, Vertex> vertices = new HashMap<>();

        void addEdge(String source, String target){
            if(!vertices.containsKey(source)){
                vertices.put(source, new Vertex(source));
            }
            if(!vertices.containsKey(target)){
                vertices.put(target, new Vertex(target));
            }
            vertices.get(source).neighbours.add(vertices.get(target));
        }

        int getMaxLength(String str, Set<String> visited){
            return dfsUtil(vertices.get(str), visited);
        }

        int dfsUtil(Vertex v, Set<String> visited){
            if(v == null){
                return 0;
            }
            visited.add(v.val);
            int maxLen = 0;
            for(Vertex n : v.neighbours){
                if(!visited.contains(n.val)){
                    maxLen = Math.max(maxLen, dfsUtil(n, visited));
                }
            }
            return maxLen+1;
        }
    }

    static class Vertex{
        String val;
        List<Vertex> neighbours;
        Vertex(String val){
            this.val = val;
            neighbours = new ArrayList<Vertex>();
        }
    }

    /*The running time is O(nlogn + n*(s)) where s is the length of the string in the array.
    n is the number of strings and it takes logn to add elements to the treeMap.
    n*s because we get all the words and remove 1 character at a time.
    Note the DFS run time is O(V+E) here E can be only n-1, so it will not affect the running time.
    Also a thing to note, I am doing DFS in the order of words with length() in descending order, and the visited set helps me do the memoization.*/
}
