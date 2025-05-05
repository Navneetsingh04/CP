import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeletionInHeap {
    List<Integer> heap;

    public DeletionInHeap(){
        heap = new ArrayList<>();
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public int leftChild(int i){
        return 2*i+1;
    }
    public int rightChild(int i){
        return 2*i+2;
    }

    public void insert(int val){
        heap.add(val);
        int currIndex = heap.size()-1;
        while(currIndex >0 && heap.get(parent(currIndex)) > heap.get(currIndex)){
            Collections.swap(heap, currIndex, parent(currIndex));
            currIndex = parent(currIndex);
        }
    }
    public void hepify(int i){
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if(left<heap.size() && heap.get(left) <heap.get(smallest)){
            smallest = left;
        }
        if(right<heap.size() && heap.get(right) < heap.get(smallest)){
            smallest = right;
        }
        if(smallest != i){
            Collections.swap(heap, i, smallest);
            hepify(smallest);
        }
    }
    public void deleteMin(){
        if(heap.isEmpty()){
            System.out.println("Heap is Empty");
            return;
        }
        // Swap root with last element and remove the last element
        Collections.swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);

        if(!heap.isEmpty()){
            hepify(0);
        }
    }
    public void printHeap(){
        System.out.println(heap);
    }
    public static void main(String[] args) {
        DeletionInHeap minHeap = new DeletionInHeap();
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(1);
        minHeap.printHeap();
        minHeap.deleteMin();
        minHeap.printHeap();
    }
}
