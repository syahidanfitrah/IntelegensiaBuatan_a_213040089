package id.dls;
import id.Node;
public class DepthLimitedSearch {
    private int limit;

    public void setLimit(int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("Limit harus lebih besar dari 0");
        }
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void search(Node start, Node goal) {
        System.out.println("Mencari solusi dari " + start.getNilai() + " ke " + goal.getNilai());
        Node sekarang = start;
        System.out.println("Kedalaman "+limit);
        for (int depth = 0; depth < limit; depth++) {
            System.out.println("Level " + depth + " evaluasi: " + sekarang.getNilai());
            if (sekarang.equals(goal)) {
                System.out.println("Solusi ditemukan");
                return;
            }
            boolean foundNext = false;
            for (Node tetangga : sekarang.getTetangga()) {
                if (!tetangga.dikunjungi()) {
                    sekarang = tetangga;
                    tetangga.setKunjungi(true);
                    foundNext = true;
                    break;
                }
            }
            if (!foundNext) {
                break;
            }
        }
        System.out.println("Tidak ditemukan solusi dalam limit kedalaman yang diberikan");
    }
}