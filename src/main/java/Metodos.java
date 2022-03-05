import java.math.BigInteger;
import java.util.Random;

class Metodos {
    public BigInteger GerarNumeroPrimo() {
        Random rand = new Random();
        BigInteger primo = new BigInteger(2048 / 2, 100, rand);
        return primo;
    }

    public BigInteger ProdutoNumerosPrimos(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    public BigInteger CalcularFuncaoTotiente(BigInteger p, BigInteger q) {
        return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    }

    public BigInteger SelecionarCoprimo(BigInteger phi) {
        BigInteger coprimo = new BigInteger("3");

        while (phi.gcd(coprimo).intValue() > 1) {
            coprimo = coprimo.add(new BigInteger("2"));
        }
        return coprimo;
    }

    public BigInteger CalcularInversoCoprimo(BigInteger e, BigInteger phi) {
        return e.modInverse(phi);
    }
}
