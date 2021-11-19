package arvoreBinaria;

public class ArvoreBinaria {
    Node root = null; // raíz

    void inserir(int info, Node place) { // uso de recursividade
        if (place == null) {
            System.out.print(" " + info);
            root = new Node(info);
        } else if (info < place.info) {
            if (place.left == null) {
                System.out.print(" " + info);
                place.left = new Node(info);
            } else {
                inserir(info, place.left);
            }
        } else if (info > place.info) {
            if (place.right == null) {
                System.out.print(" " + info);
                place.right = new Node(info);
            } else {
                inserir(info, place.right);
            }
        }
    }

    void preOrder(Node place) {
        System.out.print(" " + place.info);
        if (place.left != null) {
            preOrder(place.left);
        }
        if (place.right != null) {
            preOrder(place.right);
        }
    }

    void inOrder(Node place){
        if (place.left != null){
            inOrder(place.left);
        }
        System.out.print(" " + place.info);
        if (place.right != null){
            inOrder(place.right);
        }
    }

    void posOrder(Node place){
        if (place.left != null){
            posOrder(place.left);
        }
        if (place.right != null){
            posOrder(place.right);
        }
        System.out.print(" " + place.info);
    }
}
