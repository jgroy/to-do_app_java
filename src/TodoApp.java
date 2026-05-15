import java.util.Scanner;
import java.util.ArrayList;

class TodoApp{
    static ArrayList<Todo> todos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

        //Menu of Todos
    static void showMenu(){
        System.out.println("=========== TODO APP ==========");
        System.out.println("1. Add Todo");
        System.out.println("2. View All Todos");
        System.out.println("3. Mark Todo as Done");
        System.out.println("4. Delete Todo");
        System.out.println("5. Exit");
        System.out.println();
        System.out.print("Choose an option: ");
}
    //Adding Todos
    static void addTodo(){
    System.out.print("Enter your todo: ");
    sc.nextLine(); // clears the buffer
    String task = sc.nextLine();
    todos.add(new Todo(task));
    System.out.println("Todo added successfully!");
    System.out.println();
    System.out.println();
}
    //view the TODOs
    static void viewTodos(){
    if(todos.size() == 0){
        System.out.println("No todos yet!");
        return;
    }
    System.out.println("\n===== YOUR TODOS =====");
    for(int i = 0; i < todos.size(); i++){
        String status = todos.get(i).isDone ? "[DONE]" : "[   ]";
        System.out.println((i+1) + ". " + status + " " + todos.get(i).task);
    }
    System.out.println();
    System.out.println();
}
    //mark todos as done
    static void markDone(){
    viewTodos();
    if(todos.size() == 0) return;
    System.out.print("Enter todo number to mark as done: ");
    int num = sc.nextInt();
    if(num < 1 || num > todos.size()){
        System.out.println("Invalid number!");
        return;
    }
    todos.get(num-1).isDone = true;
    System.out.println("Marked as done!");
    System.out.println();
}
    //Delete todo
    static void deleteTodo(){
    viewTodos();
    if(todos.size() == 0) return;
    System.out.print("Enter todo number to delete: ");
    int num = sc.nextInt();
    if(num < 1 || num > todos.size()){
        System.out.println("Invalid number!");
        return;
    }
    String deleted = todos.get(num-1).task;
    todos.remove(num-1);
    System.out.println("\"" + deleted + "\" deleted!");
    System.out.println();
}

    public static void main(String args[]){
    System.out.println("Welcome to Todo App!");
    
    int choice = 0;
    while(choice != 5){
        showMenu();
        choice = sc.nextInt();
        
        if(choice == 1){
            System.out.println("Add Todo selected");
            addTodo();
        } else if(choice == 2){
            System.out.println("View Todos selected");
            viewTodos();
        } else if(choice == 3){
            System.out.println("Mark Done selected");
            markDone();
        } else if(choice == 4){
            System.out.println("Delete Todo selected");
            deleteTodo();
        } else if(choice == 5){
            System.out.println("Goodbye!");
        }
    }
}
}