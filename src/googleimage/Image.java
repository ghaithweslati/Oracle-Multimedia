/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googleimage;

/**
 *
 * @author ASUS
 */
public class Image {
    
    private String id;
    private String image;
    private String signature;
    private float similaire;

    public Image(String id, String image) {
        this.id = id;
        this.image = image;
    }

    public Image(String id,float similaire) {
        this.id = id;
        this.similaire = similaire;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public float getSimilaire() {
        return similaire;
    }

    public void setSimilaire(int similaire) {
        this.similaire = similaire;
    }
    
    
    
    
}
