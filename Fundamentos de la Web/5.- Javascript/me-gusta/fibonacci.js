function fibonacci(n, result = [0, 1]) {
    // Caso base: si n es 0 o 1, simplemente devolvemos el arreglo ya construido
    if (n <= 1) {
      return result.slice(0, n + 1);
    }
  
    // Si no hemos alcanzado el número n, calculamos el siguiente número
    result.push(result[result.length - 1] + result[result.length - 2]);
  
    // Llamada recursiva con n - 1
    return fibonacci(n - 1, result);
  }
  
  // Ejemplo de uso:
  console.log(fibonacci(5));  // Imprime [0, 1, 1, 2, 3, 5]
  console.log(fibonacci(10)); // Imprime [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
  