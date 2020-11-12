package com.epam.university.java.core.task039;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Task039Impl implements Task039 {

    private static class CodeTreeNode implements Comparable<CodeTreeNode> {
        Character content;
        int weight;
        CodeTreeNode left;
        CodeTreeNode right;

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CodeTreeNode that = (CodeTreeNode) o;
            return weight == that.weight;
        }

        @Override
        public int compareTo(CodeTreeNode o) {
            return o.weight - weight;

            //      return o.weight >= weight ? 0 : -1;
            // 1-4  return o.weight >= weight ? 0 : -1;
        }

        public String getCodeForCharacter(Character ch, String parentPath) {
            if (content == ch) {
                return parentPath;
            } else {

                if (right != null && left != null && right.equals(left)) {
                    if (right != null) {
                        String path = right.getCodeForCharacter(ch, parentPath + 0);
                        if (path != null) {
                            return path;
                        }
                    }
                    if (left != null) {
                        String path = left.getCodeForCharacter(ch, parentPath + 1);
                        if (path != null) {
                            return path;
                        }
                    }
                }


                if (right != null) {
                    String path = right.getCodeForCharacter(ch, parentPath + 1);
                    if (path != null) {
                        return path;
                    }
                }
                if (left != null) {
                    String path = left.getCodeForCharacter(ch, parentPath + 0);
                    if (path != null) {
                        return path;
                    }
                }
            }
            return null;
        }
    }

    private static CodeTreeNode huffman(ArrayList<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, right.weight + left.weight, left, right);
            codeTreeNodes.add(parent);
        }

        return codeTreeNodes.get(0);
    }


    @Override
    public Map<Character, String> getEncoding(Map<Character, Integer> charFrequencies) {
        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : charFrequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, charFrequencies.get(c)));
        }
        CodeTreeNode tree = huffman(codeTreeNodes);

        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character c : charFrequencies.keySet()) {
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }
        return codes;
    }

    @Override
    public String getEncodedString(Map<Character, Integer> charFrequencies, String string) {

        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : charFrequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, charFrequencies.get(c)));
        }
        CodeTreeNode tree = huffman(codeTreeNodes);
        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character c : charFrequencies.keySet()) {
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }

        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            encoded.append(codes.get(string.charAt(i)));
        }
        return encoded.toString();
    }

    @Override
    public String getDecodedString(Map<Character, Integer> charFrequencies, String encodedString) {

        StringBuilder decoded = new StringBuilder();
        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : charFrequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, charFrequencies.get(c)));
        }
        CodeTreeNode tree = huffman(codeTreeNodes);
        CodeTreeNode node = tree;
        for (int i = 0; i < encodedString.length(); i++) {
            node = encodedString.charAt(i) == '0' ? node.left : node.right;
            if (node.content != null) {
                decoded.append(node.content);
                node = tree;
            }
        }
        return decoded.toString();
    }

}
