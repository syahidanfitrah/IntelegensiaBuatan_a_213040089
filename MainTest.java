package id.ac.unpas.ib;

import id.ac.unpas.ib.bfs.BreadthFirstSearch;
import id.ac.unpas.ib.dls.DepthLimitedSearch;
import id.ac.unpas.ib.ucs.NodeUCS;
import id.ac.unpas.ib.ucs.UniformCostSearch;

public class MainTest {
    public static void main(String[] args) {
        // Membuat objek Node untuk mewakili kota-kota di Indonesia
        Node jakarta = new Node("Jakarta");
        Node bandung = new Node("Bandung");
        Node surabaya = new Node("Surabaya");
        Node yogyakarta = new Node("Yogyakarta");
        Node bali = new Node("Bali");
        Node makassar = new Node("Makassar");
        Node medan = new Node("Medan");

        // Menambahkan rute antara kota-kota
        jakarta.addTetangga(bandung);
        jakarta.addTetangga(yogyakarta);
        jakarta.addTetangga(surabaya);

        bandung.addTetangga(jakarta);
        bandung.addTetangga(yogyakarta);

        surabaya.addTetangga(yogyakarta);
        surabaya.addTetangga(makassar);

        yogyakarta.addTetangga(jakarta);
        yogyakarta.addTetangga(bandung);
        yogyakarta.addTetangga(surabaya);
        yogyakarta.addTetangga(bali);

        bali.addTetangga(jakarta);
        bali.addTetangga(makassar);

        makassar.addTetangga(surabaya);
        makassar.addTetangga(bali);

        medan.addTetangga(jakarta);

        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        // Mencari rute dari Jakarta ke Bali menggunakan BFS
        bfs.search(jakarta, bali);
        System.out.println();

        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(4); // Mengatur batasan kedalaman pencarian DLS
        // Mencari rute dari Jakarta ke Bali menggunakan DLS
        dls.search(jakarta, bali);
        System.out.println();

        // Membuat objek NodeUCS untuk UCS dengan bobot (jarak dalam kilometer)
        NodeUCS jakartaUCS = new NodeUCS(jakarta, 0);
        NodeUCS baliUCS = new NodeUCS(bali, 0);
        NodeUCS bandungUCS = new NodeUCS(bandung, 150);
        NodeUCS surabayaUCS = new NodeUCS(surabaya, 800);
        NodeUCS yogyakartaUCS = new NodeUCS(yogyakarta, 500);
        NodeUCS makassarUCS = new NodeUCS(makassar, 1000);

        // Menambahkan rute antara kota-kota untuk UCS
        jakartaUCS.addTetangga(bandungUCS);
        jakartaUCS.addTetangga(yogyakartaUCS);
        jakartaUCS.addTetangga(surabayaUCS);

        baliUCS.addTetangga(makassarUCS);

        bandungUCS.addTetangga(yogyakartaUCS);

        surabayaUCS.addTetangga(makassarUCS);

        yogyakartaUCS.addTetangga(baliUCS);

        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        // Mencari rute dari Jakarta ke Bali menggunakan UCS
        ucs.search(jakartaUCS, baliUCS);
        System.out.println();
    }
}

//Studi kasus di atas adalah tentang perjalanan dari Jakarta ke Bali dengan menggunakan
//berbagai algoritma pencarian, yaitu Breadth-First Search (BFS),
//Depth-Limited Search (DLS), dan Uniform Cost Search (UCS).
//
//Kota-kota dan Rute: Dalam studi kasus ini, saya menggunakan kota-kota di Indonesia 
//sebagai node dalam graf, yaitu Jakarta, Bandung, Surabaya, Yogyakarta, Bali, Makassar, 
//dan Medan. Kami menambahkan rute dan jarak antara kota-kota ini untuk merepresentasikan
//tentang perjalanan antar kota. Sebagai contoh, jarak antara Jakarta dan Bandung adalah 150 km.
//
//BFS: Pertama, menggunakan algoritma Breadth-First Search (BFS) untuk mencari rute
//dari Jakarta ke Bali. BFS melakukan pencarian dari titik awal (Jakarta) ke titik tujuan (Bali).
//Hasil pencarian ini menunjukkan jalur yang mengunjungi kota-kota secara berurutan dan mencari jalur terpendek.
//
//DLS: Selanjutnya, menggunakan algoritma Depth-Limited Search (DLS) dengan batasan kedalaman 4.
//DLS melakukan pencarian dengan membatasi kedalaman pencarian agar tidak terlalu dalam.
//Dalam konteks ini, saya mencoba mencari rute dari Jakarta ke Bali dengan membatasi jumlah maksimum kota yang dapat dikunjungi.
//
//UCS: Terakhir, saya menggunakan algoritma Uniform Cost Search (UCS) untuk mencari rute dari
//Jakarta ke Bali. UCS mencari rute dengan memperhatikan cost terkecil.
//Kami menggambarkan bobot pada setiap rute (jarak dalam kilometer) untuk mencari jalur dengan
//cost terkecil dari Jakarta ke Bali.
//
//Studi kasus ini mengilustrasikan penggunaan algoritma pencarian yang berbeda untuk
//menemukan rute dari Jakarta ke Bali dengan mempertimbangkan batasan dan bobot jarak antara kota-kota.
