func isAnagram(s string, t string) bool {
    
    var word1[26] int
    var word2[26] int
    
    for _,c := range s {
        word1[c - 'a']++
    }
    
    for _,c := range t {
        word2[c - 'a']++
    }
    
    for i:=0; i<26; i++ {
        if(word1[i] != word2[i]) {
            return false
        }
    }
    
    return true
}