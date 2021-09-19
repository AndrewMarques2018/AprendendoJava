public interface InterfaceBufer {
    void put(int valor) throws InterruptedException;
    int get() throws InterruptedException;
}
