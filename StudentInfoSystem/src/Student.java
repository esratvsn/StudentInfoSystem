public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }
    public void addBulkVerbalNote(int mat, int fizik, int kimya) {
        if (mat >= 0 && mat <= 100) {
            this.mat.verbalNote = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.verbalNote = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.verbalNote = kimya;
        }
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (
                (this.mat.note * this.mat.examWeight + this.mat.verbalNote * this.mat.verbalWeight) +
                        (this.fizik.note * this.fizik.examWeight + this.fizik.verbalNote * this.fizik.verbalWeight) +
                        (this.kimya.note * this.kimya.examWeight + this.kimya.verbalNote * this.kimya.verbalWeight)
        ) / 3;
    }
    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note + " Sözlü: " + this.mat.verbalNote);
        System.out.println("Fizik Notu : " + this.fizik.note + " Sözlü: " + this.fizik.verbalNote);
        System.out.println("Kimya Notu : " + this.kimya.note + " Sözlü: " + this.kimya.verbalNote);
    }
}
