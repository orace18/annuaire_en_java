package dao;

public class Personne {
    private int id;
    private String nom;
    private String prenoms;
    private   String adresse;
    private String tel;
    private int age;
    public Personne(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return "Id: "+this.id+", "+"Nom: "+nom+", "+"Prénoms: "+prenoms+", "+"Adresse: "+adresse+", "+"Téléphone: "+tel+", "+"Age: "+age+"ans ;";
    }
}
