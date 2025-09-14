import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(devowel(lower), word);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactWords.contains(q)) {
                res[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (caseInsensitive.containsKey(lower)) {
                    res[i] = caseInsensitive.get(lower);
                } else {
                    res[i] = vowelInsensitive.getOrDefault(devowel(lower), "");
                }
            }
        }
        return res;
    }

    private String devowel(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = '#';
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
