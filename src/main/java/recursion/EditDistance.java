package recursion;

import java.util.logging.Logger;

public class EditDistance {

    public static void main(String[] args) {
        Logger lg = Logger.getLogger("EditDistance");
        String src = "all";
        String dst = "ball";
        int result = editDistanceCount(src.toCharArray(), dst.toCharArray(), 0 ,0);
        lg.info("Edit distance count for '" + src + "'  to make it to '" + dst+ "' = "+ result);

         src = "cat";
         dst = "bcats";
         result = editDistanceCount(src.toCharArray(), dst.toCharArray(), 0 ,0);
        lg.info("Edit distance count for '" + src + "'  to make it to '" + dst+ "' = "+ result);



        src = "abcdefghij";
        dst = "akj";
        result = editDistanceCount(src.toCharArray(), dst.toCharArray(), 0 ,0);
        lg.info("Edit distance count for '" + src + "'  to make it to '" + dst+ "' = "+ result);


        src = "abc";
        dst = "xxxabcyyyzzz";
        result = editDistanceCount(src.toCharArray(), dst.toCharArray(), 0 ,0);
        lg.info("Edit distance count for '" + src + "'  to make it to '" + dst+ "' = "+ result);

        src = "cat";
        dst = "cat";
        result = editDistanceCount(src.toCharArray(), dst.toCharArray(), 0 ,0);
        lg.info("Edit distance count for '" + src + "'  to make it to '" + dst+ "' = "+ result);



    }

    private static int editDistanceCount(char[] src, char[] dst, int srcIdx, int dstIdx) {
        if(srcIdx==src.length) {
            return dst.length-dstIdx;
        }
        if(dstIdx==dst.length) {
            return src.length-srcIdx;
        }
        if(src[srcIdx]==dst[dstIdx]) {
            return editDistanceCount(src, dst, srcIdx+1, dstIdx+1);
        }
        return 1 + Math.min(
                editDistanceCount(src,dst, srcIdx, dstIdx+1),
                Math.min(editDistanceCount(src, dst, srcIdx+1, dstIdx),
                        editDistanceCount(src,dst,srcIdx+1, dstIdx+1)));
    }
}
