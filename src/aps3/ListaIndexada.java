package aps3;

public class ListaIndexada<T> {

    private class No {

        private T data;
        private No proximo;
        private No anterior;

        private No pula10Frente;
        private No pula10Tras;

        private No pula100Frente;
        private No pula100Tras;

        private No pula1000Frente;
        private No pula1000Tras;

        private No pula1500Frente;
        private No pula1500Tras;

        public No(T valor) {
            data = valor;
        }

        public T getData() {
            return data;
        }
    }

    public void criaPulos() {
        No pula10 = head;
        No pula100 = head;
        No pula1000 = head;
        No pula1500 = head;

        No current = head;

        pula10.pula10Frente = tail;
        pula100.pula100Frente = tail;
        pula1000.pula1000Frente = tail;
        pula1500.pula1500Frente = tail;

        int cont = 1;
        while (current != null) {
            if ((cont % 25) == 0) {
                pula10.pula10Frente = current;
                current.pula10Tras = pula10;
                current.pula10Frente = tail;

                pula10 = current;
            }
            if ((cont % 100) == 0) {
                pula100.pula100Frente = current;
                current.pula100Tras = pula100;
                current.pula100Frente = tail;

                pula100 = current;
            }
            if ((cont % 1000) == 0) {
                pula1000.pula1000Frente = current;
                current.pula1000Tras = pula1000;
                current.pula1000Frente = tail;

                pula1000 = current;
            }
            if ((cont % 1500) == 0) {
                pula1500.pula1500Frente = current;
                current.pula1500Tras = pula1500;
                current.pula1500Frente = tail;
            }

            current = current.proximo;
            cont++;
        }
        if (tail.pula10Tras == null) {
            tail.pula10Tras = pula10;
        }
        if (tail.pula100Tras == null) {
            tail.pula100Tras = pula100;
        }
        if (tail.pula1000Tras == null) {
            tail.pula1000Tras = pula1000;
        }
        if (tail.pula1500Tras == null) {
            tail.pula1500Tras = pula1500;
        }
    }

    public void buscaNumeros(int num) {
        No current = head;
        boolean Found = false;
        int pulos = 0;

        while (current != null) {
            if ((Integer) current.getData() > num) {
                break;
            }

            if ((Integer) current.getData() != num) {
                pulos++;
                if ((current.pula1500Frente != null) && ((Integer) current.pula1500Frente.data <= num)) {
                    current = current.pula1500Frente;
                } else if ((current.pula1000Frente != null) && ((Integer) current.pula1000Frente.data <= num)) {
                    current = current.pula1000Frente;
                } else if ((current.pula100Frente != null) && ((Integer) current.pula100Frente.data <= num)) {
                    current = current.pula100Frente;
                } else if ((current.pula10Frente != null) && ((Integer) current.pula10Frente.data <= num)) {
                    current = current.pula10Frente;
                } else {
                    current = current.proximo;
                }
            } else {
                Found = true;
                break;
            }
            System.out.println("Valor com o nó: " + current.data);
        }
        if (Found) {
            System.out.println("Numero de pulos: " + pulos);
        }
    }

    public void mostraHeadLista() {
        No current = head;
        while (current != null) {
            System.out.println((current.getData()));
            current = current.proximo;
        }
    }

    public void mostraTailLista() {
        No current = tail;
        while (current != null) {
            System.out.println((current.getData()));
            current = current.proximo;
        }
    }

    private No head;
    private No tail;
    private int tamanhoLista = 0;

    void append(T value) {
        No novo = new No(value);
        tamanhoLista++;
        if (tail != null) {
            if (head.proximo == null) {
                head.proximo = novo;
                tail = novo;
                tail.anterior = head;
            } else {
                novo.anterior = tail;
                tail.proximo = novo;
                tail = novo;
            }
        } else {
            head = novo;
            tail = novo;
        }
    }
}
