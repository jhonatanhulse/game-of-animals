package jhullse.gameofanimals;

import java.util.Scanner;

import jhullse.gameofanimals.util.mutable.BinaryTreeNavigator;
import jhullse.gameofanimals.util.mutable.BinaryTreeNavigatorImpl;
import jhullse.gameofanimals.util.mutable.BinaryTreeNode;
import jhullse.gameofanimals.util.mutable.BinaryTreeNodeImpl;

public class ConsoleApp {

    public static void main(String[] args) {
        BinaryTreeNode parent = new BinaryTreeNodeImpl("vive na água");
        BinaryTreeNode leftChild = new BinaryTreeNodeImpl("tubarão");
        BinaryTreeNode rightChild = new BinaryTreeNodeImpl("macaco");

        parent.setLeftChild(leftChild);
        parent.setRightChild(rightChild);

        BinaryTreeNavigator navigator = new BinaryTreeNavigatorImpl(parent);

        Boolean isLeftChild = null;
        Boolean previousIsLeftChild;
        BinaryTreeNode current;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pense em um animal ...");

            do {
                String answer;
                StringBuilder stringBuilder = new StringBuilder();
                current = navigator.getCurrent();
                previousIsLeftChild = isLeftChild;
                isLeftChild = null;

                if (current.isLeaf()) {
                    stringBuilder.append("O animal que você pensou é o/a ");
                } else {
                    stringBuilder.append("Esse animal ");
                }

                stringBuilder.append(current.getObject());
                stringBuilder.append("?(s/n):");

                do {
                    System.out.println(stringBuilder.toString());
                    answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("s")) {
                        isLeftChild = true;
                    } else if (answer.equalsIgnoreCase("n")) {
                        isLeftChild = false;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                } while (isLeftChild == null);
            } while (navigator.next(isLeftChild) != null);

            if (isLeftChild) {
                System.out.println("Acertei denovo!");
            } else {
                String newLeafObject, newParentObject;

                do {
                    System.out.println("Qual animal você pensou?:");
                    newLeafObject = scanner.nextLine();
                    if (newLeafObject.isEmpty()) {
                        System.out.println("Valor inválido!");
                    }
                } while (newLeafObject.isEmpty());

                do {
                    System.out.println("Complete a frase:Esse animal ______________ mas o/a " + current.getObject() + " não.");
                    newParentObject = scanner.nextLine();
                    if (newParentObject.isEmpty()) {
                        System.out.println("Valor inválido!");
                    }
                } while (newParentObject.isEmpty());

                BinaryTreeNode newLeaf = new BinaryTreeNodeImpl(newLeafObject);
                BinaryTreeNode newParent = new BinaryTreeNodeImpl(newParentObject);
                BinaryTreeNode oldParent = current.getParent();

                newParent.setLeftChild(newLeaf);
                newParent.setRightChild(current);

                if (previousIsLeftChild) {
                    oldParent.setLeftChild(newParent);
                } else {
                    oldParent.setRightChild(newParent);
                }
            }

            navigator.rewind();
        }
    }
}
