/*75. sort colors
algorithm: O(n), one pass solusion, use three pointers to mark the first position of 0, 1, 2,
when instance of 0 falls behind of head pointers of 1 or 2, swap the elements, move the head pointers backward.

when instance of 1 falls behind of head pointers of 2, swaps the elements.

for the instance of 2, nothing to worry about, since we make sure that all the time head of 0 infront of head of 1, then 2.

*/

 public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] head = new int[3];
        
        for (int i = 0; i < 3;i++){
            head[i] = -1;
        }
        
        for (int i = 0; i < A.length ; i++){
            int n = A[i];
            if (head[n] == -1) head[n] = i;
            
            if (n==0) {
                if (head[1]!=-1&&head[2]==-1) {
                    if (head[1]<head[0]) head[0] = head[1];
                    A[head[1]] = 0;
                    A[i] = 1;
                    head[1] ++;
                } else if (head[2]!=-1&&head[1]==-1){
                    if (head[2]<head[0]) head[0] = head[2];
                    A[head[2]] = 0;
                    A[i] = 2;
                    head[2] ++;
                } else if (head[2]!=-1&&head[1]!=-1){
                    if (head[1]<head[0]) head[0] = head[1];
                    A[head[1]] = 0;
                    A[head[2]] = 1;
                    A[i] = 2;
                    head[1]++;
                    head[2]++;
                }
                
            } else if (n==1){
                if (head[2]!=-1) {
                    if (head[2] < head[1] )head[1] = head[2];
                    A[head[2]] = 1;
                    A[i] = 2;
                    head[2] ++;
                     
                }
            }
        }
    }
