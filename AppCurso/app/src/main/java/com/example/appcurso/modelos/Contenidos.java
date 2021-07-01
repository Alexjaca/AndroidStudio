package com.example.appcurso.modelos;

import com.example.appcurso.R;

public class Contenidos {

    private Pagina[] mpaginas;

    public Contenidos(){
        mpaginas = new Pagina[8];

        mpaginas[0] = new Pagina(
                R.drawable.img0,
                "Saludos Joven %1$s, aqui empieza tu viaje, si lo haces bien, conseguiras la victoria",
                new Opcion("Entrenarme",1),
                new Opcion("Luchar",2));

        mpaginas[1] = new Pagina(
                R.drawable.img1,
                "Hazte un experto en el manejo de una de estas armas",
                new Opcion("Elijo el Palo",3),
                new Opcion("Elijo la Espada",4));

        mpaginas[2] = new Pagina(
                R.drawable.img2,
                "Este es el legendario Suzuki Miyamoto, maestroen el manejo de estrellas ninja",
                new Opcion("No, volver a entrenar",1),
                new Opcion("Si, Luchar ya",6));


        mpaginas[3] = new Pagina(
                R.drawable.img3,
                "texto de ejemplo, Disena tu Historia",
                new Opcion("Estoy listo quiero luchar",2),
                new Opcion("quiero aprender a manejar la espadar",4));


        mpaginas[4] = new Pagina(
                R.drawable.img4,
                "Bien, has Elegido aprender a usar la Espada, ahora Suzuki esta despistado",
                new Opcion("Quiero luchar con Honor",5),
                new Opcion("Atacar por la Espalda",2));


        mpaginas[5] = new Pagina(
                R.drawable.img5,
                "Este es Suzuki maestro, usar Palo o Espada",
                new Opcion("Palo",6),
                new Opcion("Espada",7));


        mpaginas[6] = new Pagina(
                R.drawable.img6,
                "Haz elegido tu destino y has elegido mal");


        mpaginas[7] = new Pagina(
                R.drawable.img7,
                "Has elegido tu destino y has trabajado duto, aqui tienes tus estrellas");
    }

    public Pagina getpage (int pageNumbre){
        return  mpaginas[pageNumbre];
    }
}
