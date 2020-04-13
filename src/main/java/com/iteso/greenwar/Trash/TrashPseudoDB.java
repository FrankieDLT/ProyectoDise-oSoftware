package com.iteso.greenwar.Trash;
import com.iteso.greenwar.Trash.Basura;
import org.junit.Test;

import java.util.Random;

/**
 * This class will act as a database of sorts from which an object type "Basura".
 * will be drawn to be played with
 * @author FrankDLT
 * @version 06/04/2020/1.0
 * */



/*
* básico      -> organico, inorganico
* intermedio  -> reciclable, organico, inorganico
*
* reciclable: Metal, Vidrio, Papel
*
* avanzado    -> Orgánico, Papel (P), Vidrio, Metal,
*                Plástico (PL), Textiles y Basura tecnológica (B)
*
* nota: carton se clasifica como papel
*
* añadir opcion de información en el menu pricipal
*
* Streak Points: (1.25^Streak)*points
* */
public class TrashPseudoDB{

    private Random Ra = new Random();
    int ran=0;

    /**
     * This method recieves a object and changes its name and its type to a certain one depending
     * on the type of trash selected by a random number
     *@author FrankDLT
     *@version 06/04/2020/1.0
     * @return*/
    public Basura SelectB(Basura b){

        ran = Ra.nextInt(200);

        switch (ran){
            case 0: b.setName("Funko Roto"); b.setClasification("PL"); break;
            case 1: b.setName("Bateria de Laptop"); b.setClasification("B");break;
            case 2: b.setName("Sobras de Comida"); b.setClasification("O");break;
            case 3: b.setName("Clips de Oficina"); b.setClasification("M");break;
            case 4: b.setName("Colcha Deshilachada"); b.setClasification("T");break;
            case 5: b.setName("Disco DVD"); b.setClasification("B");break;
            case 6: b.setName("Cuaderno Usado"); b.setClasification("P");break;
            case 7: b.setName("Servilleta Normal");b.setClasification("P"); break;
            case 8: b.setName("Servilleta Tejida"); b.setClasification("T");break;
            case 9: b.setName("Control de Nintendo"); b.setClasification("B");break;
            case 10: b.setName("Termo de Cafe"); b.setClasification("M");break;
            case 11: b.setName("Cascara de Huevo"); b.setClasification("O");break;
            case 12: b.setName("Cascara de Platano"); b.setClasification("O");break;
            case 13: b.setName("Huesos de Pollo"); b.setClasification("O");break;
            case 14: b.setName("Peluche Roto"); b.setClasification("T");break;
            case 15: b.setName("Calcetines con Hoyos"); b.setClasification("T");break;
            case 16: b.setName("Cuchillo sin Filo"); b.setClasification("M");break;
            case 17: b.setName("Lentes de Sol sin Cristales"); b.setClasification("M");break;
            case 18: b.setName("Botella de Agua"); b.setClasification("PL");break;
            case 19: b.setName("Anillo de Compromiso (ouch!)"); b.setClasification("M");break;
            case 20: b.setName("VHS"); b.setClasification("B");break;
            case 21: b.setName("Cadena de Collar"); b.setClasification("M");break;
            case 22: b.setName("Marcapasos"); b.setClasification("B");break;
            case 23: b.setName("Pedazos de Ventana"); b.setClasification("V");break;
            case 24: b.setName("Jarra de Cafetera"); b.setClasification("V");break;
            case 25: b.setName("Tijeras"); b.setClasification("M");break;
            case 26: b.setName("Camisa Rota"); b.setClasification("T");break;
            case 27: b.setName("Zapatos");b.setClasification("T"); break;
            case 28: b.setName("Defensa de Carro");b.setClasification("M"); break;
            case 29: b.setName("Foco Fundido");b.setClasification("V"); break;
            case 30: b.setName("Carta Leida");b.setClasification("P"); break;
            case 31: b.setName("Pañuelo Usado"); b.setClasification("P");break;
            case 32: b.setName("Guantes"); b.setClasification("T");break;
            case 33: b.setName("Termo Infantil");b.setClasification("PL"); break;
            case 34: b.setName("Envoltorio de Dulce");b.setClasification("PL"); break;
            case 35: b.setName("Hebilla de Pantalon"); b.setClasification("M");break;
            case 36: b.setName("Muñeco de Batman sin Cabeza");b.setClasification("PL"); break;
            case 37: b.setName("Control Remoto"); b.setClasification("B");break;
            case 38: b.setName("Fotos Familiares"); b.setClasification("P");break;
            case 39: b.setName("Cartucho de Nintendo 64"); b.setClasification("B");break;
            case 40: b.setName("Funda de Celular"); b.setClasification("PL");break;
            case 41: b.setName("USB"); b.setClasification("B");break;
            case 42: b.setName("Guía del autoestopista galáctico (libro)"); b.setClasification("P");break;
            case 43: b.setName("Sandalias"); b.setClasification("PL");break;
            case 44: b.setName("Bolo de Boliche");b.setClasification("PL"); break;
            case 45: b.setName("Pelota de Baloncesto");b.setClasification("PL"); break;
            case 46: b.setName("Casco de Constructor");b.setClasification("PL"); break;
            case 47: b.setName("Calaverita de Azucar"); b.setClasification("O");break;
            case 48: b.setName("Pan de Muerto Viejo"); b.setClasification("O");break;
            case 49: b.setName("Pluma sin Tinta"); b.setClasification("PL");break;
            case 50: b.setName("Boligrafo Sin Tinta");b.setClasification("M"); break;
            case 51: b.setName("Botella de Vino"); b.setClasification("V");break;
            case 52: b.setName("Corbata Fea"); b.setClasification("T");break;
            case 53: b.setName("Poster Viejo"); b.setClasification("P");break;
            case 54: b.setName("Toper Manchado"); b.setClasification("PL");break;
            case 55: b.setName("Caja de Galletas"); b.setClasification("P");break;
            case 56: b.setName("Blue Ray Descompuesta"); b.setClasification("B");break;
            case 57: b.setName("Cubre Bolante");b.setClasification("T"); break;
            case 58: b.setName("Hojas de Arbol"); b.setClasification("O");break;
            case 59: b.setName("Cable HDMI"); b.setClasification("B");break;
            case 60: b.setName("Restos de Café");b.setClasification("O"); break;
            case 61: b.setName("Pétalos de Flores");b.setClasification("O"); break;
            case 62: b.setName("Adorno de Cristal"); b.setClasification("V");break;
            case 63: b.setName("Pantalla de TV de los 70s"); b.setClasification("V");break;
            case 64: b.setName("Pantalla de TV del 2020");b.setClasification("PL"); break;
            case 65: b.setName("Juguete Amiibo"); b.setClasification("PL");break;
            case 66: b.setName("Vaso de Precipitado"); b.setClasification("V");break;
            case 67: b.setName("Gotero"); b.setClasification("V");break;
            case 68: b.setName("Retrovisor Roto"); b.setClasification("V");break;
            case 69: b.setName("Lata de Comida");b.setClasification("M"); break;
            case 70: b.setName("Tenedor Doblado"); b.setClasification("M");break;
            case 71: b.setName("Cubo Rubik"); b.setClasification("PL");break;
            case 72: b.setName("Guitarra sin Cuerdas");b.setClasification("O"); break;
            case 73: b.setName("Violín Roto");b.setClasification("O"); break;
            case 74: b.setName("Coca de Lata"); b.setClasification("M");break;
            case 75: b.setName("Pieza de Parabrisas"); b.setClasification("V");break;
            case 76: b.setName("Celular"); b.setClasification("B");break;
            case 77: b.setName("Computadora con Windows Vista"); b.setClasification("B");break;
            case 78: b.setName("Placa de Perro");b.setClasification("M"); break;
            case 79: b.setName("Tiara de Juguete"); b.setClasification("PL");break;
            case 80: b.setName("Pistola de Juguete"); b.setClasification("PL");break;
            case 81: b.setName("Cerdas de Escoba"); b.setClasification("PL");break;
            case 82: b.setName("Mango de Cuchillo de Cocina Barato"); b.setClasification("PL");break;
            case 83: b.setName("Hueso de Mango"); b.setClasification("O");break;
            case 84: b.setName("Cristal de Lente de Camara"); b.setClasification("V");break;
            case 85: b.setName("Camara Digital"); b.setClasification("B");break;
            case 86: b.setName("Mouse"); b.setClasification("B");break;
            case 87: b.setName("Estampilla"); b.setClasification("P");break;
            case 88: b.setName("Manual de Uso"); b.setClasification("P");break;
            case 89: b.setName("Legos"); b.setClasification("PL");break;
            case 90: b.setName("Bola Disco"); b.setClasification("V");break;
            case 91: b.setName("Corazón de Manzana"); b.setClasification("O");break;
            case 92: b.setName("Envase de Jugo"); b.setClasification("PL");break;
            case 93: b.setName("Mapa de Calles"); b.setClasification("P");break;
            case 94: b.setName("Recetario"); b.setClasification("P");break;
            case 95: b.setName("Licuadora"); b.setClasification("B");break;
            case 96: b.setName("Tostadora"); b.setClasification("B");break;
            case 97: b.setName("Regla de Aluminio");b.setClasification("M"); break;
            case 98: b.setName("Lienzo"); b.setClasification("T");break;
            case 99: b.setName("Acetato Roto"); b.setClasification("PL");break;
            case 100: b.setName("Pantalón de Mezclilla"); b.setClasification("T");break;
            case 101: b.setName("Botella de Shampoo");b.setClasification("PL"); break;
            case 102: b.setName("Toalla Vieja"); b.setClasification("T");break;
            case 103: b.setName("Ropa Interior");b.setClasification("T"); break;
            case 104: b.setName("Cartas de Pokemon"); b.setClasification("P");break;
            case 105: b.setName("Funda de Almohada"); b.setClasification("T");break;
            case 106: b.setName("Trapo Viejo"); b.setClasification("T");break;
            case 107: b.setName("Estopa"); b.setClasification("T");break;
            case 108: b.setName("Sueter"); b.setClasification("T");break;
            case 109: b.setName("Paleacate"); b.setClasification("T");break;
            case 110: b.setName("Palo de Paleta"); b.setClasification("O");break;
            case 111: b.setName("Bolsa del Mandado"); b.setClasification("PL");break;
            case 112: b.setName("Micro Fibra para Lentes"); b.setClasification("T");break;
            case 113: b.setName("Boleto de Avión Viejo"); b.setClasification("P");break;
            case 114: b.setName("Dados"); b.setClasification("PL");break;
            case 115: b.setName("Candelabro"); b.setClasification("V");break;
            case 116: b.setName("Espejo"); b.setClasification("V");break;
            case 117: b.setName("Florero");b.setClasification("V"); break;
            case 118: b.setName("Bolsa de Papitas");b.setClasification("PL"); break;
            case 119: b.setName("Heces de Animal"); b.setClasification("O");break;
            case 120: b.setName("Animal Atropellado");b.setClasification("O"); break;
            case 121: b.setName("Llanta de Carro"); b.setClasification("PL");break;
            case 122: b.setName("Puerta de Acero Torcida");b.setClasification("M"); break;
            case 123: b.setName("Cesta de Basura de Aluminio"); b.setClasification("M");break;
            case 124: b.setName("Tuercas"); b.setClasification("M");break;
            case 125: b.setName("Clavos"); b.setClasification("M");break;
            case 126: b.setName("Desarmador"); b.setClasification("M");break;
            case 127: b.setName("Martillo"); b.setClasification("M");break;
            case 128: b.setName("Residuo de Café");b.setClasification("O"); break;
            case 129: b.setName("Queso Rancio"); b.setClasification("O");break;
            case 130: b.setName("Fruta Hechada a Perder"); b.setClasification("O");break;
            case 131: b.setName("Tuvo de Escape"); b.setClasification("M");break;
            case 132: b.setName("Gato Hidráulico");b.setClasification("M"); break;
            case 133: b.setName("Bateria de Celular");b.setClasification("B"); break;
            case 134: b.setName("Disco Duro"); b.setClasification("B");break;
            case 135: b.setName("Nintendo GameBoy"); b.setClasification("B");break;
            case 136: b.setName("Calabaza de Halloween"); b.setClasification("O");break;
            case 137: b.setName("Uñas"); b.setClasification("O");break;
            case 138: b.setName("Cabello"); b.setClasification("O");break;
            case 139: b.setName("Gasas"); b.setClasification("O");break;
            case 140: b.setName("Residuos de Pasto"); b.setClasification("O");break;
            case 141: b.setName("Bolsa de Té"); b.setClasification("O");break;
            case 142: b.setName("Paja"); b.setClasification("O");break;
            case 143: b.setName("Cenizas"); b.setClasification("O");break;
            case 144: b.setName("Yerba de Mate");b.setClasification("O"); break;
            case 145: b.setName("Cáscara de Nuez"); b.setClasification("O");break;
            case 146: b.setName("Raíces"); b.setClasification("O");break;
            case 147: b.setName("Madera"); b.setClasification("O");break;
            case 148: b.setName("Cascara de Naranja"); b.setClasification("O");break;
            case 149: b.setName("Huesos de Pescado"); b.setClasification("O");break;
            case 150: b.setName("Pepinillos"); b.setClasification("O");break;
            case 151: b.setName("Radio"); b.setClasification("B");break;
            case 152: b.setName("Carton de Huevos"); b.setClasification("P");break;
            case 153: b.setName("Carton de Leche"); b.setClasification("P");break;
            case 154: b.setName("Recibo de la Luz Viejo");b.setClasification("P"); break;
            case 155: b.setName("Carpeta"); b.setClasification("P");break;
            case 156: b.setName("Triptico"); b.setClasification("P");break;
            case 157: b.setName("Cajita Feliz");b.setClasification("P"); break;
            case 158: b.setName("Examen de Primer Semestre"); b.setClasification("P");break;
            case 159: b.setName("Cartulina"); b.setClasification("P");break;
            case 160: b.setName("Audífonos"); b.setClasification("B");break;
            case 161: b.setName("Aire Acondicionado Descompuesto");b.setClasification("B"); break;
            case 162: b.setName("Control de Wii"); b.setClasification("B");break;
            case 163: b.setName("Ipad"); b.setClasification("B");break;
            case 164: b.setName("Guia Televisiva"); b.setClasification("P");break;
            case 165: b.setName("Tarjeta RAM"); b.setClasification("B");break;
            case 166: b.setName("Comic Viejo"); b.setClasification("P");break;
            case 167: b.setName("Moneda de 10 Centavos"); b.setClasification("M");break;
            case 168: b.setName("Reloj de Bolsillo"); b.setClasification("M");break;
            case 169: b.setName("Stickers"); b.setClasification("P");break;
            case 170: b.setName("Barra Desodorante Vacia");b.setClasification("PL"); break;
            case 171: b.setName("Brazalete");b.setClasification("T"); break;
            case 172: b.setName("Cubo de Cargador"); b.setClasification("B");break;
            case 173: b.setName("Lata de Aerosol"); b.setClasification("M");break;
            case 174: b.setName("Caja de Unicel"); b.setClasification("PL");break;
            case 175: b.setName("Pan"); b.setClasification("O");break;
            case 176: b.setName("Periodico"); b.setClasification("P");break;
            case 177: b.setName("Cartera de Cuero"); b.setClasification("O");break;
            case 178: b.setName("Cartucho de Tinta"); b.setClasification("B");break;
            case 179: b.setName("Semillas"); b.setClasification("O");break;
            case 180: b.setName("Aserrín"); b.setClasification("O");break;
            case 181: b.setName("Chicle"); b.setClasification("PL");break;
            case 182: b.setName("Tarjeta de Crédito"); b.setClasification("PL");break;
            case 183: b.setName("Chaleco");b.setClasification("T"); break;
            case 184: b.setName("Bufanda"); b.setClasification("T");break;
            case 185: b.setName("Bolsa de Mano"); b.setClasification("T");break;
            case 186: b.setName("Mascarilla"); b.setClasification("T");break;
            case 187: b.setName("Bisturi"); b.setClasification("M");break;
            case 188: b.setName("Guantes Medicos"); b.setClasification("PL");break;
            case 189: b.setName("Pluma de Pajaro"); b.setClasification("O");break;
            case 190: b.setName("Caparazon de Cangrejo"); b.setClasification("O");break;
            case 191: b.setName("Alfombra Manchada"); b.setClasification("T");break;
            case 192: b.setName("Morral Viejo"); b.setClasification("T");break;
            case 193: b.setName("Mochila Rota"); b.setClasification("T");break;
            case 194: b.setName("Gancho Barato");b.setClasification("PL"); break;
            case 195: b.setName("Aguja"); b.setClasification("M");break;
            case 196: b.setName("Portaretratos de Aluminio"); b.setClasification("M");break;
            case 197: b.setName("Cinta Métrica"); b.setClasification("PL");break;
            case 198: b.setName("Dulce Añejo"); b.setClasification("O");break;
            case 199: b.setName("Botón de Camisa"); b.setClasification("PL");break;
            case 200: b.setName("Alfiletero"); b.setClasification("T");break;
            default:b.setName("ERROR"); b.setClasification("E");break;
        }

        return b;
    }


    @Test
    public void TestRandom(){
        Basura Test = SelectB(new Basura());
        System.out.println("Name: " + Test.getName()
                + "\nClass: "+Test.getClasification());
    }



}
