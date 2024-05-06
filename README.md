# Library Service App

## Concept
The idea behind this app is to have a system for libraries that easily allows customers and library assistants to manage their accounts and the library inventory, respectively. With our app, users can easily log which items they have checked out, and they can just as easily mark which items they have returned. The app seamlessly updates the current inventory as customers borrow and return items, and even allows them to make requests to the library for items they would like to see available for borrowing. On the other side, assistants can easily update the library inventory whenever new items are added or removed, and they can see what customers have requested to be available in the library too in case the library needs inspiration for new items to add.

## Important Notes
- Whenever you perform actions as a user or assistant, you must click the 'Sign out' button for the changes to be saved. Simply exiting the app without signing out will not save anything done in that session.
- It is easiest to run the app through the terminal. Make sure that your current path is in Library-Service/src. Then, run these two commands: javac Main.java  -d ../bin | java -classpath ../bin Main
- If for some reason, you want to clear the memory of the system, you will have to delete both the current ppl.bin and data.bin files- you cannot keep one of them and delete the other.

### Class Diagram

![ClassDiagram](./diagrams/Class_Diagram.png)

### Use Case Diagram

![Usecase](./diagrams/UsecaseDiagram.png)

### Use Case Descriptions

![UsecaseDescriptions(./diagrams/UseCaseDescriptions.png)

### Login as new user Sequence Diagram

![new user login](./diagrams/newUser.jpg)

### Login as existing user Sequence Diagram

![old user login](./diagrams/oldUser.jpg)

### Borrow item Sequence Diagram

![borrow item](./diagrams/borrow.jpg)

### Return Item Sequence Diagram

![return item](./diagrams/returnSequenceDiagram.png)

### View All Sequence Diagram

![view all items](./diagrams/viewAllSequenceDiagram.png)

### Add Item Sequence Diagram

![AddItemSq](./diagrams/AddItemSequence.png)

### Delete Item Sequence Diagram

![DeleteItemSq](./diagrams/DeleteItemSequence.png)

### List Request Item Sequence Diagram

![ListReqItemSq](./diagrams/ListRequestItemSequence.png)
