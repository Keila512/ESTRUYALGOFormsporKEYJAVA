package ESTRUCORDENAFormsJAVAporKEY;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Form1 extends JFrame {
    private static final long serialVersionUID = 1L; // Add this line
    private JTabbedPane tabbedPane;  // Agregamos un JTabbedPane

    private List<Integer> data = new ArrayList<>();
    private Stack<Integer> pila = new Stack<>();
    private Queue<Integer> cola = new LinkedList<>();
    private List<Integer> lista = new ArrayList<>();
    private BinaryTree arbol = new BinaryTree();
    private Graph grafo = new Graph();

    private JComboBox<String> cmbOrdenamientos;
    private JTextArea txtDatos;
    private JButton btnEjecutarOrdenamientos;
    private JButton btnAgregarDatos;
    private JButton btnLimpiarDatos;
    JTextField txtDatos1 = new JTextField();
    JTextField txtDatos2 = new JTextField();
    JTextField txtDatos3 = new JTextField();

    private JTextField txtPila;
    private JTextField txtCola;
    private JTextField txtLista;
    private JTextField txtArbol;
    private JTextField txtGrafo;
    
    
    private JButton btnAgregarPila;
    private JButton btnEliminarPila;
    private JButton btnMostrarPila;

    private JButton btnEncolarCola;
    private JButton btnDesencolarCola;
    private JButton btnMostrarCola;

    private JButton btnAgregarLista;
    private JButton btnEliminarLista;
    private JButton btnMostrarLista;

    private JButton btnInsertarArbol;
    private JButton btnBuscarArbol;
    private JButton btnMostrarArbol;

    private JButton btnAgregarVerticeGrafo;
    private JButton btnAgregarAristaGrafo;
    private JButton btnMostrarGrafo;


    // Otros componentes necesarios...

    public Form1() {
        // Replace the layout manager with BorderLayout
        this.getContentPane().setLayout(new BorderLayout());

        // Call the initComponents method
        initComponents();

        // Pack and set visible
        pack();
        setVisible(true);
    }


    private void initComponents() {
    	String[] algoritmos = {"Bubble Sort", "Selection Sort", "Insertion Sort", "QuickSort", "MergeSort", "HeapSort",
                "ShellSort", "CountingSort", "RadixSort", "Salir"};
        cmbOrdenamientos = new JComboBox<>(algoritmos);
        tabbedPane = new JTabbedPane();
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
     // Configurar pestañas
        tabbedPane.addTab("Ordenamientos", createOrdenamientosPanel());
        tabbedPane.addTab("Pila", createDataStructurePanel("Pila", btnAgregarPila, btnEliminarPila, btnMostrarPila, txtPila));
        tabbedPane.addTab("Cola", createDataStructurePanel("Cola", btnEncolarCola, btnDesencolarCola, btnMostrarCola, txtCola));
        tabbedPane.addTab("Lista", createDataStructurePanel("Lista", btnAgregarLista, btnEliminarLista, btnMostrarLista, txtLista));
        tabbedPane.addTab("Árbol", createDataStructurePanel("Árbol", btnInsertarArbol, btnBuscarArbol, btnMostrarArbol, txtArbol));
        tabbedPane.addTab("Grafo", createDataStructurePanel("Grafo", btnAgregarVerticeGrafo, btnAgregarAristaGrafo, btnMostrarGrafo, txtGrafo));

        cmbOrdenamientos.setSelectedIndex(0);

        // Asegúrate de inicializar otros componentes necesarios, como btnEjecutarOrdenamientos,
        // btnAgregarDatos, btnLimpiarDatos y txtDatos.
        btnEjecutarOrdenamientos = new JButton("Ejecutar Ordenamientos");
        btnAgregarDatos = new JButton("Agregar Datos");
        btnLimpiarDatos = new JButton("Limpiar Datos");
        txtDatos = new JTextArea(2, 20); // 10 filas y 30 columnas
       

        

        btnAgregarPila = new JButton("Agregar a Pila");
        btnEliminarPila = new JButton("Eliminar de Pila");
        btnMostrarPila = new JButton("Mostrar Pila");

        btnEncolarCola = new JButton("Encolar a Cola");
        btnDesencolarCola = new JButton("Desencolar Cola");
        btnMostrarCola = new JButton("Mostrar Cola");

        btnAgregarLista = new JButton("Agregar a Lista");
        btnEliminarLista = new JButton("Eliminar de Lista");
        btnMostrarLista = new JButton("Mostrar Lista");

        btnInsertarArbol = new JButton("Insertar en Árbol");
        btnBuscarArbol = new JButton("Buscar en Árbol");
        btnMostrarArbol = new JButton("Mostrar Árbol");

        btnAgregarVerticeGrafo = new JButton("Agregar Vértice en Grafo");
        btnAgregarAristaGrafo = new JButton("Agregar Arista en Grafo");
        btnMostrarGrafo = new JButton("Mostrar Grafo");
        this.getContentPane().setLayout(new BorderLayout());
        // Crear el JTabbedPane
        

        
        // Agregar listeners y otros ajustes...
        cmbOrdenamientos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutarAlgoritmoOrdenamiento();
            }
        });
        // Añadir listener para cambiar el título de la ventana al cambiar de pestaña
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setTitle("Estructuras de Datos - " + tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
            }
        });
        // Agregar listeners a los botones
        btnAgregarPila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int elemento = obtenerElementoDesdeInput();
                pushToStack(elemento);
            }
        });

        btnEliminarPila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                popFromStack();
            }
        });

        btnMostrarPila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPila();
            }
        });

        btnEncolarCola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int elemento = obtenerElementoDesdeInput();
                enqueueToQueue(elemento);
            }
        });

        btnDesencolarCola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dequeueFromQueue();
            }
        });

        btnMostrarCola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCola();
            }
        });

        btnAgregarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int elemento = obtenerElementoDesdeInput();
                addToArrayList(elemento);
            }
        });

        btnEliminarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int elemento = obtenerElementoDesdeInput();
                removeFromArrayList(elemento);
            }
        });

        btnMostrarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarLista();
            }
        });

        btnInsertarArbol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int elemento = obtenerElementoDesdeInput();
                String prioridad = obtenerPrioridadDesdeInput();
                insertIntoTree(elemento, prioridad);
            }
        });

        btnBuscarArbol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int elemento = obtenerElementoDesdeInput();
                searchInTree(elemento);
            }
        });

        btnMostrarArbol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarArbol();
            }
        });

        btnAgregarVerticeGrafo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int vertice = obtenerVerticeDesdeInput();
                addVertex(vertice);
            }
        });

        btnAgregarAristaGrafo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int inicio = obtenerVerticeDesdeInput();
                int fin = obtenerVerticeDesdeInput();
                addEdgeToGraph(inicio, fin);
            }
        });

        btnMostrarGrafo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarGrafo();
            }
        });

        btnEjecutarOrdenamientos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutarAlgoritmoOrdenamiento();
            }
        });

        btnAgregarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = txtDatos.getText();
                agregarDatos(input);
            }
        });

        btnLimpiarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarDatos();
            }
        });
        // Instead of adding btnAgregarPila directly to the content pane, use the panel returned by createDataStructurePanel
     
    
    }

    
    private JPanel createDataStructurePanel(String title, JButton btnAgregar, JButton btnEliminar, JButton btnMostrar, JTextField txtDatos) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createTitledBorder(title));

        // Add components to the panel
        panel.add(new JLabel("Datos:"));
        panel.add(txtDatos);
        panel.add(btnAgregar);
        panel.add(btnEliminar);
        panel.add(btnMostrar);

        // La excepción podría ocurrir aquí si alguno de los botones o el JTextField es null

        return panel;
    }

    private JPanel createOrdenamientosPanel() {
        JPanel panel = new JPanel(new FlowLayout()); // Puedes ajustar el diseño según tus necesidades

        // Agregar cmbOrdenamientos al panel de Ordenamientos
        panel.add(cmbOrdenamientos);

        // Agregar otros componentes relacionados con los ordenamientos si es necesario

        return panel;
    }

    
    // Métodos para obtener datos desde campos de texto (puedes implementar según tu diseño)
    private int obtenerElementoDesdeInput() {
        // Lógica para obtener el elemento desde un campo de texto, por ejemplo txtDatos1
        return Integer.parseInt(txtDatos1.getText());
    }

    private String obtenerPrioridadDesdeInput() {
        // Lógica para obtener la prioridad desde un campo de texto, por ejemplo txtDatos2
        return txtDatos2.getText();
    }

    private int obtenerVerticeDesdeInput() {
        // Lógica para obtener el vértice desde un campo de texto, por ejemplo txtDatos3
        return Integer.parseInt(txtDatos3.getText());
    }

    // Métodos para mostrar mensajes (puedes adaptar según tu diseño)
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Métodos para mostrar información de las estructuras
    private void mostrarPila() {
        mostrarMensaje("Contenido de la Pila: " + pila.toString());
    }

    private void mostrarCola() {
        mostrarMensaje("Contenido de la Cola: " + cola.toString());
    }

    private void mostrarLista() {
        mostrarMensaje("Contenido de la Lista: " + lista.toString());
    }

    private void mostrarArbol() {
        // Puedes implementar la lógica para mostrar el árbol según tu diseño
        // Por ejemplo, puedes usar un recorrido (inorden, preorden, postorden) para mostrar los nodos
        // o simplemente mostrar la representación visual del árbol en un cuadro de diálogo.
        mostrarMensaje("Árbol Binario: " + arbol.toString());
    }

    private void mostrarGrafo() {
        // Puedes implementar la lógica para mostrar el grafo según tu diseño
        mostrarMensaje("Grafo: " + grafo.toString());
    }

   
private void ejecutarAlgoritmoOrdenamiento() {
int selectedSort = cmbOrdenamientos.getSelectedIndex();

switch (selectedSort) {
    case 0:
        bubbleSort(data);
        break;
    case 1:
        selectionSort(data);
        break;
    case 2:
        insertionSort(data);
        break;
    case 3:
        quickSort(data, 0, data.size() - 1);
        break;
    case 4:
        mergeSort(data, 0, data.size() - 1);
        break;
    case 5:
        heapSort(data);
        break;
    case 6:
        shellSort(data);
        break;
    case 7:
        countingSort(data);
        break;
    case 8:
        radixSort(data);
        break;
    // Añade más casos según sea necesario para otros algoritmos
}

// Mostrar los datos ordenados
JOptionPane.showMessageDialog(null, "Datos ordenados: " + data);
 
}
    public static void bubbleSort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    // Intercambiar elementos si están en el orden incorrecto
                    int temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }}
        }

    public static void selectionSort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Intercambiar el elemento mínimo con el primer elemento sin ordenar
            int temp = data.get(minIndex);
            data.set(minIndex, data.get(i));
            data.set(i, temp);}
        }

        public static void insertionSort(List<Integer> data) {
            int n = data.size();
            for (int i = 1; i < n; i++) {
                int key = data.get(i);
                int j = i - 1;
                // Mover los elementos del array que son mayores que key a una posición adelante de su posición actual
                while (j >= 0 && data.get(j) > key) {
                    data.set(j + 1, data.get(j));
                    j--;
                }
                // Insertar el elemento key en su posición correcta
                data.set(j + 1, key);
            }
        }

        public static void quickSort(List<Integer> data, int low, int high) {
            if (low < high) {
                int partitionIndex = partition(data, low, high);
                quickSort(data, low, partitionIndex - 1);
                quickSort(data, partitionIndex + 1, high);
            }
        }

        private static int partition(List<Integer> data, int low, int high) {
            int pivot = data.get(high);
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (data.get(j) < pivot) {
                    i++;
                    swap(data, i, j);
                }
            }

            swap(data, i + 1, high);
            return i + 1;
        }

        public static void mergeSort(List<Integer> data, int left, int right) {
            if (left < right) {
                int middle = (left + right) / 2;
                mergeSort(data, left, middle);
                mergeSort(data, middle + 1, right);
                merge(data, left, middle, right);
            }
        }

        private static void merge(List<Integer> data, int left, int middle, int right) {
            int n1 = middle - left + 1;
            int n2 = right - middle;

            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            for (int i = 0; i < n1; ++i) {
                leftArray[i] = data.get(left + i);
            }
            for (int j = 0; j < n2; ++j) {
                rightArray[j] = data.get(middle + 1 + j);
            }

            int i = 0, j = 0, k = left;
            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    data.set(k, leftArray[i]);
                    i++;
                } else {
                    data.set(k, rightArray[j]);
                    j++;
                }
                k++;
            }

            while (i < n1) {
                data.set(k, leftArray[i]);
                i++;
                k++;
            }

            while (j < n2) {
                data.set(k, rightArray[j]);
                j++;
                k++;
            }
        }

        public static void heapSort(List<Integer> data) {
            int n = data.size();

            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(data, n, i);
            }

            for (int i = n - 1; i > 0; i--) {
                int temp = data.get(0);
                data.set(0, data.get(i));
                data.set(i, temp);

                heapify(data, i, 0);
            }
        }

        private static void heapify(List<Integer> data, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && data.get(left) > data.get(largest)) {
                largest = left;
            }

            if (right < n && data.get(right) > data.get(largest)) {
                largest = right;
            }

            if (largest != i) {
                swap(data, i, largest);
                heapify(data, n, largest);
            }
        }

        public static void shellSort(List<Integer> data) {
            int n = data.size();
            for (int gap = n / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < n; i += 1) {
                    int temp = data.get(i);
                    int j;
                    for (j = i; j >= gap && data.get(j - gap) > temp; j -= gap) {
                        data.set(j, data.get(j - gap));
                    }
                    data.set(j, temp);
                }
            }
        }

        private static void swap(List<Integer> data, int i, int j) {
            int temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        public static void countingSort(List<Integer> data) {
            int max = getMaxValue(data);

            int[] count = new int[max + 1];
            int n = data.size();
            int[] output = new int[n];

            // Inicializar el arreglo de conteo
            Arrays.fill(count, 0);

            // Contar la frecuencia de cada elemento
            for (int i = 0; i < n; ++i) {
                count[data.get(i)]++;
            }

            // Calcular las posiciones reales de los elementos en el arreglo de salida
            for (int i = 1; i <= max; ++i) {
                count[i] += count[i - 1];
            }

            // Construir el arreglo de salida
            for (int i = n - 1; i >= 0; --i) {
                output[count[data.get(i)] - 1] = data.get(i);
                count[data.get(i)]--;
            }

            // Copiar el arreglo de salida al arreglo original
            for (int i = 0; i < n; ++i) {
                data.set(i, output[i]);
            }
        }

        private static int getMaxValue(List<Integer> data) {
            int max = Integer.MIN_VALUE;
            for (int num : data) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }

        public static void radixSort(List<Integer> data) {
            int max = getMaxValue(data);

            for (int exp = 1; max / exp > 0; exp *= 10) {
                countingSortRadix(data, exp);
            }
        }

        private static void countingSortRadix(List<Integer> data, int exp) {
            int n = data.size();
            int[] output = new int[n];
            int[] count = new int[10];

            Arrays.fill(count, 0);

            // Contar la frecuencia de cada dígito en la posición actual
            for (int i = 0; i < n; ++i) {
                count[(data.get(i) / exp) % 10]++;
            }

            // Calcular las posiciones reales de los elementos en el arreglo de salida
            for (int i = 1; i < 10; ++i) {
                count[i] += count[i - 1];
            }

            // Construir el arreglo de salida
            for (int i = n - 1; i >= 0; --i) {
                output[count[(data.get(i) / exp) % 10] - 1] = data.get(i);
                count[(data.get(i) / exp) % 10]--;
            }

            // Copiar el arreglo de salida al arreglo original
            for (int i = 0; i < n; ++i) {
                data.set(i, output[i]);
            }
        }

    // Métodos de manipulación de datos y otras operaciones...

        private void agregarDatos(String input) {
            // Procesa los datos según sea necesario
            String[] elementos = input.split(" ");
            for (String elemento : elementos) {
                try {
                    int num = Integer.parseInt(elemento);
                    data.add(num);
                } catch (NumberFormatException ex) {
                    // Maneja la excepción si la entrada no es un número válido
                    ex.printStackTrace();
                }
            }

            // Actualiza la presentación de los datos o realiza otras acciones necesarias
            cmbOrdenamientos.repaint();
            JOptionPane.showMessageDialog(null, "Datos agregados correctamente.");
        }

        public void limpiarDatos() {
            data.clear();
            System.out.println("Datos limpiados.");
        }
     // Dentro de la clase Form1, después de los métodos de ordenamiento

     // Método para agregar un elemento a la pila
     private void pushToStack(int element) {
         pila.push(element);
         JOptionPane.showMessageDialog(null, "Elemento " + element + " agregado a la pila.");
     }

     // Método para eliminar un elemento de la pila
     private void popFromStack() {
         if (!pila.isEmpty()) {
             int poppedElement = pila.pop();
             JOptionPane.showMessageDialog(null, "Elemento " + poppedElement + " eliminado de la pila.");
         } else {
             JOptionPane.showMessageDialog(null, "La pila está vacía.");
         }
     }

     // Método para encolar un elemento
     private void enqueueToQueue(int element) {
         cola.add(element);
         JOptionPane.showMessageDialog(null, "Elemento " + element + " encolado.");
     }

     // Método para desencolar un elemento
     private void dequeueFromQueue() {
         if (!cola.isEmpty()) {
             int dequeuedElement = cola.poll();
             JOptionPane.showMessageDialog(null, "Elemento " + dequeuedElement + " desencolado.");
         } else {
             JOptionPane.showMessageDialog(null, "La cola está vacía.");
         }
     }

     // Método para agregar un elemento a la lista
     private void addToArrayList(int element) {
         lista.add(element);
         JOptionPane.showMessageDialog(null, "Elemento " + element + " agregado a la lista.");
     }

     // Método para eliminar un elemento de la lista
     private void removeFromArrayList(int element) {
         if (lista.contains(element)) {
             lista.remove(Integer.valueOf(element)); // Necesario convertir a Integer para usar remove(Object)
             JOptionPane.showMessageDialog(null, "Elemento " + element + " eliminado de la lista.");
         } else {
             JOptionPane.showMessageDialog(null, "El elemento " + element + " no está en la lista.");
         }
     }

 
  // Método para insertar un elemento en el árbol
     private void insertIntoTree(int element, String priority) {
         arbol.insertar(element, priority);
         JOptionPane.showMessageDialog(null, "Elemento " + element + " con prioridad " + priority + " insertado en el árbol.");
     }

     // Método para buscar un elemento en el árbol
     private void searchInTree(int element) {
         if (arbol.buscar(element)) {
             JOptionPane.showMessageDialog(null, "El elemento " + element + " está en el árbol.");
         } else {
             JOptionPane.showMessageDialog(null, "El elemento " + element + " no está en el árbol.");
         }
     }

  // Método para agregar un vértice al grafo
     public void addVertex(int vertice) {
         if (!grafo.getAdjacencyList().containsKey(vertice)) {
             grafo.getAdjacencyList().put(vertice, new ArrayList<>());
         }
     }


     // Método para agregar una arista al grafo
     private void addEdgeToGraph(int startVertex, int endVertex) {
         grafo.addEdge(startVertex, endVertex);
         JOptionPane.showMessageDialog(null, "Arista agregada entre " + startVertex + " y " + endVertex + " en el grafo.");
     }

     // Método para mostrar el grafo
     private void displayGraph() {
         JOptionPane.showMessageDialog(null, "Representación del grafo:\n" + grafo.toString());
     }



     public static void main(String[] args) {
    	    SwingUtilities.invokeLater(new Runnable() {
    	        public void run() {
    	            Form1 ventana = new Form1();
    	            ventana.initComponents();
    	            ventana.setSize(800, 600);
    	            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	            ventana.setVisible(true);
    	        }
    	    });
    	}
}
    