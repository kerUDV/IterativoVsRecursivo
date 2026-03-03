# ED_Parcial_Kerwin

##Descripción del Proyecto
Este proyecto consiste en la implementación y comparación de algoritmos iterativos y recursivos en Java.  
Se analizaron sus tiempos de ejecución mediante mediciones reales utilizando `System.nanoTime()` y se compararon los resultados experimentales con su complejidad teórica (Big-O).

Los algoritmos implementados fueron:
- A1 – Factorial
- A2 – Fibonacci
- A3 – Búsqueda Lineal
- A4 – Ordenamiento Burbuja

Cada algoritmo fue ejecutado 5 veces por tamaño de entrada y posteriormente se generaron gráficas en Excel para visualizar su comportamiento.

---

## Objetivo

Comparar el rendimiento de versiones iterativas y recursivas de distintos algoritmos y comprobar experimentalmente cómo se comportan según su complejidad temporal.

---

## Tecnologías Utilizadas

- Java (JDK 25)
- IntelliJ IDEA
- Microsoft Excel
- Git y GitHub

---

## Estructura del Proyecto
src/
├── algorithms/
│ ├── Factorial.java
│ ├── Fibonacci.java
│ ├── BusquedaLineal.java
│ └── OrdenamientoBurbuja.java
│
├── benchmark/
│ ├── Main.java
│ └── Medidor.java
│
└── utils/
└── GeneradorDatos.java

resultados/
└── tiempos.csv

Cómo Compilar

Desde la carpeta raíz del proyecto:

```bash
javac -d out src/algorithms/*.java src/benchmark/*.java src/utils/*.java

