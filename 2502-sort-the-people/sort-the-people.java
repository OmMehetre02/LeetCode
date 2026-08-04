class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = heights.length;
        
        // Bubble Sort (Descending)
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                
                if(heights[j] < heights[j + 1]) {
                    
                    // swap heights
                    int tempH = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = tempH;
                    
                    // swap names
                    String tempN = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempN;
                }
            }
        }
        
        return names;
    }
}