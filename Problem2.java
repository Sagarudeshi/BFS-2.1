// Time Complexity : O(N), N is number of employees
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N



/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer, Employee> map = new HashMap<>(); //map to retrieve employee
        int N = employees.size();

        if(N==0)
            return 0;

        for(int i=0;i<N;i++){
            map.put(employees.get(i).id, employees.get(i)); //add employees
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id)); //add base id
        int result = 0;

        while(!queue.isEmpty()){ //BFS traversal
            Employee curr = queue.poll();
            List<Integer> subordinates = curr.subordinates;

            result += curr.importance; //add current employee importance

            for(Integer subordinate : subordinates){
                queue.add(map.get(subordinate));
            }
        }

        return result;
    }
}