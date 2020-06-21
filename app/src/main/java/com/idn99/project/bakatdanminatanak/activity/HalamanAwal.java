package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.ModelBakat;
import com.idn99.project.bakatdanminatanak.model.ModelCiriBakat;
import com.idn99.project.bakatdanminatanak.model.ModelCiriKarakter;
import com.idn99.project.bakatdanminatanak.model.ModelKarakter;

import java.util.ArrayList;

public class HalamanAwal extends AppCompatActivity {

    private Button btnMulai, btnAbout, btnMateri, btnHistory;

    DBHelper dbHelper;
    ArrayList<ModelBakat> dataBakat = new ArrayList<>();
    ArrayList<ModelKarakter> addKar = new ArrayList<>();
    ArrayList<ModelCiriBakat> addCB = new ArrayList<>();
    ArrayList<ModelCiriKarakter> addData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_awal);

        btnMulai = findViewById(R.id.btn_mulai);
        btnAbout = findViewById(R.id.btn_about);
        btnMateri = findViewById(R.id.btn_home_pen);
        btnHistory = findViewById(R.id.btn_history);

        dbHelper = new DBHelper(getApplicationContext());

        addDataBakat();
        for (int i=0;i<dataBakat.size();i++){
            ModelBakat modelBakat = dataBakat.get(i);
            dbHelper.addRecordBakat(modelBakat);
        }

        setAddKar();
        for (int i=0;i<addKar.size();i++){
            ModelKarakter modelKarakter = addKar.get(i);
            dbHelper.addRecordKarakter(modelKarakter);
        }

        addData();
        for (int i=0;i<addCB.size();i++){
            ModelCiriBakat modelCiriBakat = addCB.get(i);
            dbHelper.addRecordCiriBakat(modelCiriBakat);
        }

        addDataKar();
        for (int i=0;i<addData.size();i++){
            ModelCiriKarakter modelCiriKarakter = addData.get(i);
            dbHelper.addRecordCiriKarakter(modelCiriKarakter);
        }

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mulai.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
            }
        });

        btnMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PengenalanBakatKarakter.class);
                startActivity(intent);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), History.class);
                startActivity(intent);
            }
        });

    }

    public void addDataBakat(){
        dataBakat.add(new ModelBakat(1,"Intelektual Umum","Anak cenderung menyukai hal-hal yang bersifat pengetahuan. Orang tua dapat memberikan pendidikan tentang pengetahuan umum. Orang tua dapat memberikan ensiklopedia agar pengetahuan anak semakin berkembang"));
        dataBakat.add(new ModelBakat(2,"Akademik Khusus","Anak cenderung menyukai hal-hal yang bersifat logis. Orang tua dapat memberikan pendidikan tentang perhitungan, fisika, dan kimia"));
        dataBakat.add(new ModelBakat(3,"Berfikir Kreatif dan Produktif", "Anak cenderung menyukai hal-hal yang bersifat senang dalam membuat suatu barang. Orang tua dapat memberikan pendidikan tentang hal-hal baru dan menciptakan sesuatu yang sederhana"));
        dataBakat.add(new ModelBakat(4,"Kepemimpinan","Anak cenderung menyukai hal-hal yang bersifat kebersamaan. Orang tua dapat memberikan pendidikan tentang bagaimana mengatur hal-hal kecil sampai organisasi/kelompok sederhana"));
        dataBakat.add(new ModelBakat(5,"Seni Visual dan Pertunjukan","Anak cenderung menyukai hal-hal yang bersifat seni. Orang tua dapat memberikan pendidikan tentang kesenian daerah maupun kesenian luar"));
        dataBakat.add(new ModelBakat(6,"Psikomotorik","Anak cenderung menyukai hal-hal yang bersifat aktif. Orang tua dapat memberikan pendidikan tentang berolahraga dengan baik dan cabang olah raga yang digemari"));
    }

    public void setAddKar(){
        addKar.add(new ModelKarakter(1,"#f58e8e","Koleris","Belajar dengan metode pemecahan masalah, debat serta presentasi","Koleris yang kuat merupakan tipe kepribadian yang tegas dan tipe seorang pemimpin. Koleris sangat suka mengatur, suka petualangan, suka tantangan baru, memiliki ketegasan dalam menentukan keputusan, tidak mudah menyerah, tidak mudah mengalah. Tipe koleris menjadi sosok yang selalu diidam- idamkan oleh orang lain karena terlihat sangat keren dan kuat dari luar. Namun dibalik semua kesempurnaan dirinya dan jiwa kepemimpinannya yang besar, orang koleris cenderung jarang bersenang- senang"));
        addKar.add(new ModelKarakter(2,"#8ea4f5","Melankolis", "Belajar secara terjadwal, diskusi atau membuat prakarya","Tipe Kepribadian Melankolis yang sempurna merupakan tipe kepribadian yang memiliki karakter cenderung bersikap rapi, teratur, terencana, dan mampu mempertimbangkan segala sesuatu dengan melihat hal- hal kecil. Secara penampilan fisik, orang dengan tipe melankolis sempurna tampak rapi, baju mulus, sepatu bersih, barang bawaan tertata rapi, buku tertata dengan rapi, tulisan rapi"));
        addKar.add(new ModelKarakter(3,"#f5f38e","Plegmatis","Belajar berkelompok serta diskusi","Seseorang dengan tipe karakter phlegmatis menunjukkan pribadi yang mudah diatur, cenderung diam dan kalem, suka mengalah, memiliki rasa toleransi yang tinggi, mudah untuk disuruh dan selalu mau melakukan, suka mengalah, tidak menyukai konflik. Orang dengan tipe ini suka dengan kehidupan yang damai- damai saja dan tenang. Apabila dihadapkan pada suatu masalah, maka dia akan mencari solusi dengan cara damai dan diselesaikan dengan tenang. Tipe plegmatis mampu bersabar dalam kondisi apapun. Apabila disuruh untuk mengambil keputusan, mengalami kesulitas dan cenderung menunda- nunda" ));
        addKar.add(new ModelKarakter(4,"#8ef59d","Sanguinis","Belajar dengan berdiskusi untuk menyelesaikan masalah, presentasi serta permainan","Sanguinis merupakan tipe karakter kepribadian yang suka menjadi bahan perhatian, ingin selalu disenangi oleh orang lain, menyukai kepopuleran, memiliki rasa percaya diri yang tinggi dan senang menjadi pusat perhatian. Seorang sanguinis selalu senang dalam situasi yang gembira, pesta- pesta, berkumpul dengan teman- teman dalam kondisi yang ramai. Senang terhadap aktivitas kebersamaan yang menyenangkan, namun hidupnya tidak teratur. Orang dengan tipe sanguinis susah berkonsentrasi dan diajak serius. Selalu cenderung memberikan keputusan setelah berpikir pendek"));
    }

    public void addData(){
        addCB.add(new ModelCiriBakat(1, 1,"Dapat menirukan kalimat sederhana"));
        addCB.add(new ModelCiriBakat(2, 1, "Anak anda dapat meniru kembali 4-5 urutan kata"));
        addCB.add(new ModelCiriBakat(3, 1, "Anak anda dapat mengulangi kalimat yang sudah didengarnya"));
        addCB.add(new ModelCiriBakat(4, 1, "Anak anda dapat menyanyikan lagu anak-anak lebih dari 20 lebih lagu"));
        addCB.add(new ModelCiriBakat(5, 1, "Anak anda dapat menyebutkan simbol-simbol huruf vokal dan konsonan"));
        addCB.add(new ModelCiriBakat(6, 1, "Anak anda dapat mengucapkan syair lagu sambil diiringi senandung lagunya"));
        addCB.add(new ModelCiriBakat(7, 1, "Anak anda dapat mengelompokkan benda dengan berbagai cara menurut fungsinya"));
        addCB.add(new ModelCiriBakat(8, 1, "Apakah anak anda dapat meniru berbagai lambang huruf vokal dan konsonan"));
        addCB.add(new ModelCiriBakat(9, 1, "Anak anda dapat mengelompokkan benda dengan berbagai cara menurut fungsinya : misalnya peralatan makan, peralatan mandi, peralatan kebersihan"));
        addCB.add(new ModelCiriBakat(10, 1, "Anak anda dapat menggunakan dan dapat menjawab pertanyaan apa, mengapa, dimana, berapa, bagaimana, dsb"));
        addCB.add(new ModelCiriBakat(11, 1, "Anak anda dapat bercerita tentang gambar yang disediakan atau dibuat sendiri"));
        addCB.add(new ModelCiriBakat(12, 1, "Anak anda dapat bercerita menggunakan kata ganti aku, saya, kamu, mereka, dll"));
        addCB.add(new ModelCiriBakat(13, 1, "Anak anda dapat menceritakan pengalaman/kejadian secara sederhana"));
        addCB.add(new ModelCiriBakat(14, 1, "Anak anda dapat memberikan keterangan/informasi tentang suatu hal"));

        addCB.add(new ModelCiriBakat(15, 2, "Anak anda dapat menyebutkan urutan bilangan 1-10"));
        addCB.add(new ModelCiriBakat(16, 2,"Anak anda dapat menunjuk lambang bilangan 1-10"));
        addCB.add(new ModelCiriBakat(17, 2,"Anak anda dapat meniru lambang bilangan 1-10"));
        addCB.add(new ModelCiriBakat(18, 2,"Anak anda dapat mengenal lambang bilangan 1-20"));
        addCB.add(new ModelCiriBakat(19, 2,"Anak anda dapat membedakan dan membuat dua kumpulan benda berdasarkan kuantitasnya"));
        addCB.add(new ModelCiriBakat(20, 2,"Anak anda dapat mengenal perbedaan benda berdasarkan bentuknya"));
        addCB.add(new ModelCiriBakat(21, 2,"Anak anda dapat mencoba dan menceritakan tentang proses"));
        addCB.add(new ModelCiriBakat(22, 2,"Anak anda dapat mencoba dan menceritakan tentang proses benda-benda dimasukkan kedalam air (terapung, tenggelam)"));
        addCB.add(new ModelCiriBakat(23, 2,"Anak anda dapat menceritakan macam-macam bunyi"));
        addCB.add(new ModelCiriBakat(24, 2,"Anak anda dapat menceritakan macam-macam rasa"));
        addCB.add(new ModelCiriBakat(25, 2,"Anak anda dapat menceritakan macam-macam bau"));

        addCB.add(new ModelCiriBakat(26, 3,"Anak anda mau mengungkapkan pendapat secara sederhana"));
        addCB.add(new ModelCiriBakat(27, 3,"Anak anda dapat menjawab pertanyaan tentang informasi/keterangan"));
        addCB.add(new ModelCiriBakat(28, 3,"Anak anda menyapa teman dan orang lain"));
        addCB.add(new ModelCiriBakat(29, 3,"Anak anda dapat mengucapkan salam"));
        addCB.add(new ModelCiriBakat(30, 3,"Anak anda selalu mengucapkan terima kasih jika memperoleh sesuatu"));
        addCB.add(new ModelCiriBakat(31, 3,"Anak anda dapat mengekspresikan perasaannya, misalnya : marah, sedih, gembira, dll"));
        addCB.add(new ModelCiriBakat(32, 3,"Anak anda dapat membuat perencanaan kegiatan yang dilakukan anak"));
        addCB.add(new ModelCiriBakat(33, 3,"Anak anda mampu mengambil keputusan secara sederhana"));
        addCB.add(new ModelCiriBakat(34, 3,"Anak anda dapat menggambar bebas dengan berbagai media"));
        addCB.add(new ModelCiriBakat(35, 3,"Anak anda mau menunjukkan perbuatan yang benar dan yang salah"));
        addCB.add(new ModelCiriBakat(36, 3,"Anak anda suka menolong"));
        addCB.add(new ModelCiriBakat(37, 3,"Anak anda mau bermain dengan teman sebaya tanpa membedakan : warna kulit, keturunan, rambut, agama, dll"));
        addCB.add(new ModelCiriBakat(38, 3,"Anak anda dapat menghargai hasil karya teman/orang lain"));
        addCB.add(new ModelCiriBakat(39, 3,"Anak anda dapat menghargai keunggulan teman/orang lain"));
        addCB.add(new ModelCiriBakat(40, 3,"Anak anda dapat mengajak teman untuk bermain"));
        addCB.add(new ModelCiriBakat(41, 3,"Anak anda mau menolong dan memberi maaf"));
        addCB.add(new ModelCiriBakat(42, 3,"Anak anda dapat hidup berdampingan dengan teman agama lain"));
        addCB.add(new ModelCiriBakat(43, 3,"Anak anda dapat memuji teman atau orang lain"));
        addCB.add(new ModelCiriBakat(44, 3,"Anak anda dapat berpakaian rapi dan sopan"));
        addCB.add(new ModelCiriBakat(45, 3,"Anak anda dapat menghormati guru, orang tua dan orang yang lebih tua"));
        addCB.add(new ModelCiriBakat(46, 3,"Anak anda dapat mendengarkan dan memperhatikan teman yang berbicara"));
        addCB.add(new ModelCiriBakat(47, 3,"Anak anda dapat memelihara hasil karya sendiri"));
        addCB.add(new ModelCiriBakat(48, 3,"Anak anda dapat mentaati aturan permainan"));

        addCB.add(new ModelCiriBakat(49, 4,"Anak anda berani bertanya dan menjawab pertanyaan"));
        addCB.add(new ModelCiriBakat(50, 4,"Anak anda dapat bertanggung jawab akan tugasnya"));
        addCB.add(new ModelCiriBakat(51, 4,"Anak anda dapat melaksanakan tugas sendiri sampai selesai"));
        addCB.add(new ModelCiriBakat(52, 4,"Anak anda dapat melakukan 3-5 perintah secara berurutan dengan benar"));
        addCB.add(new ModelCiriBakat(53, 4,"Anak anda dapat melaksanakan tugas kelompok"));
        addCB.add(new ModelCiriBakat(54, 4,"Anak anda dapat bekerja sama dengan teman"));
        addCB.add(new ModelCiriBakat(55, 4,"Anak anda mau bermain dengan teman"));
        addCB.add(new ModelCiriBakat(56, 4,"Anak anda dapat saling membantu sesama teman"));
        addCB.add(new ModelCiriBakat(57, 4,"Anak anda mau membantu memecahkan perselisihan/permasalahan"));
        addCB.add(new ModelCiriBakat(58, 4,"Anak anda mau berbagi dengan teman"));
        addCB.add(new ModelCiriBakat(59, 4,"Anak anda mau meminjamkan miliknya"));
        addCB.add(new ModelCiriBakat(60, 4,"Anak anda sabar menunggu giliran"));
        addCB.add(new ModelCiriBakat(61, 4,"Anak anda dapat mengendalikan emosi dengan cara wajar"));
        addCB.add(new ModelCiriBakat(62, 4,"Anak anda dapat menerima kritik"));

        addCB.add(new ModelCiriBakat(63, 5,"Anak anda dapat melukiskan apa yang dilihat, didengar dalam sebuah kertas"));
        addCB.add(new ModelCiriBakat(64, 5,"Anak anda dapat menggambar bebas dari bentuk dasar titik, garis, lingkaran, segitiga, segiempat"));
        addCB.add(new ModelCiriBakat(65, 5,"Anak anda dapat memainkan alat musik, seperti angklung, piano"));
        addCB.add(new ModelCiriBakat(66, 5,"Anak anda dapat memahami tangga nada"));
        addCB.add(new ModelCiriBakat(67, 5,"Anak anda dapat mengekspresikan gerakan sesuai dengan syair lagi/cerita, iringan musik/lagu"));
        addCB.add(new ModelCiriBakat(68, 5,"Anak anda dapat mengekspresikan diri dalam gerakan"));
        addCB.add(new ModelCiriBakat(69, 5,"Anak anda mampu bermain peran"));

        addCB.add(new ModelCiriBakat(70, 6,"Anak anda mampu menggunakan sepeda dengan seimbang"));
        addCB.add(new ModelCiriBakat(71, 6,"Anak anda mampu menangkap bola yang memantul"));
        addCB.add(new ModelCiriBakat(72, 6,"Anak anda mampu berdiri dengan satu kaki secara seimbang"));
        addCB.add(new ModelCiriBakat(73, 6,"Anak anda sangat senang bergerak (sulit diam)"));
        addCB.add(new ModelCiriBakat(74, 6,"Anak anda sangat senang berolahraga"));
        addCB.add(new ModelCiriBakat(75, 6,"Anak anda sangat senang berlari pagi"));

    }

    private void addDataKar(){
        addData.add(new ModelCiriKarakter(1,1,"Anak Bisa Berdiri Sendiri"));
        addData.add(new ModelCiriKarakter(2,1,"Anak Tegas"));
        addData.add(new ModelCiriKarakter(3,1,"Anak Produktif"));
        addData.add(new ModelCiriKarakter(4,1,"Anak Tidak Mudah Bersimpati"));
        addData.add(new ModelCiriKarakter(5,1,"Anak Suka Menguasai"));
        addData.add(new ModelCiriKarakter(6,1,"Anak Suka Menang Sendiri"));

        addData.add(new ModelCiriKarakter(7,2,"Anak Suka Menganalisa"));
        addData.add(new ModelCiriKarakter(8,2,"Anak Perfeksionis"));
        addData.add(new ModelCiriKarakter(9,2,"Anak Dapat Menjaga Mainannya"));
        addData.add(new ModelCiriKarakter(10,2,"Anak Idealis"));
        addData.add(new ModelCiriKarakter(11,2,"Anak Pemurung"));
        addData.add(new ModelCiriKarakter(12,2,"Anak Sering Berfikiran Negatif"));
        addData.add(new ModelCiriKarakter(13,2,"Anak Pengkritik"));

        addData.add(new ModelCiriKarakter(14,3,"Anak Tenang dan Pendiam"));
        addData.add(new ModelCiriKarakter(15,3,"Anak Mudah Bergaul"));
        addData.add(new ModelCiriKarakter(16,3,"Anak Susah Punyai Motivasi"));
        addData.add(new ModelCiriKarakter(17,3,"Anak Menghindari Konflik"));
        addData.add(new ModelCiriKarakter(18,3,"Anak Pengamat"));

        addData.add(new ModelCiriKarakter(19,4,"Anak Periang"));
        addData.add(new ModelCiriKarakter(20,4,"Anak Bersifat Positif"));
        addData.add(new ModelCiriKarakter(21,4,"Anak Selalu Bersemangan"));
        addData.add(new ModelCiriKarakter(22,4,"Anak Kurang Disiplin"));
    }


}
