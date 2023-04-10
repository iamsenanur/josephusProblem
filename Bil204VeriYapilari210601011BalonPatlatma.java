/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bil204veriyapilari210601011balonpatlatma;


import java.util.Scanner;//scanner sinifini java kutuphanesinden cagiriyorum.


public class Bil204VeriYapilari210601011BalonPatlatma {
    
    
    public static class Uygulama{
       //Node sinifinin Uygulama sinifi icinde bir ic (inner)sınıf olarak yazıyorum.
        public static class Node{
        // Node sinifinda int tipinde "data" ve bir sonraki dugumu gostereck bagSahasi var.    
        public int data;
        public Node bagSahasi;
        //Constructor yaziyoruz.-->Node dugumunu her calistirdiginda bir constructor olustursun ve node dugumu olussun.
        Node(int d){
            data=d;
            bagSahasi=null;
        }
    }
        //static olarak tanimlanacak ve N ile M degerlerini parametre olarak alacak balonPozisyonuBul metodunu yaziyorum.
         public static void balonPozisyonuBul(int N, int M){
             
                Node head =new Node(1);//Bağlı listenin basliangic dugumunu olusturur. Dugumun data degeri 1 olarak atanir.
                Node endNode= head;
                //N adet balondan olusacak Dairesel Bagli listemizi olusturuyorum.
                
                for(int i=2; i<=N;i++){
                    Node newNode=new Node(i);
                    endNode.bagSahasi = newNode;
                    endNode = newNode;
                    endNode.bagSahasi = head;}
        //Liste elamanlarimi yazdirma
/*        
    Node current = head;
    do {
    System.out.print(current.data + " ");
    current = current.next;
      } while (current != head);*/
                   

    //Olusturulan bu liste uzerinde son kalan balonu bulmak icin gerekli olan algoritmayi yaziyorum.
         while(true){
             for(int j=0; j<M-1; j++){
                 head=head.bagSahasi;
                 endNode = endNode.bagSahasi;
             }
             endNode.bagSahasi = head.bagSahasi;
              head = head.bagSahasi;
             
             if(head.bagSahasi==head){
                 break;
             }
         }
    //Son kalan balonun pozisyonunu yazdiriyorum.
        System.out.println("Son kalan balonun pozisyonu:" +head.data);
        
       }
    }

    public static void main(String[] args) {
        System.out.println("********BALON PATLATMA OYUNUNA HOŞGELDİNİZ********");
        System.out.println("Girdiğiniz N değeri sıralanacak balon adetini verir!");
        System.out.println("Girdiğiniz M değeri M-1 kadar eleman atlatılıp bir balonun patlatılcağını belirtir!");
        
        Scanner tarayici =new Scanner(System.in);
        
        //Kullanicidan klavyeden N ve M degerlerini girilmesi istenip gerekli kosul kontrollerini gerçeklestiriyorum.
        System.out.println("N degerini giriniz: ");
        int N= tarayici.nextInt();
        
        if (N <= 0) {
         System.out.println("Klavyeden girilen N değeri 0' dan büyük olmalıdır! Program sonlandırıldı!");
         System.exit(0); // Programi sonlandirdim!
}
        
        System.out.println("M degerini giriniz: ");
        int M= tarayici.nextInt();
        
        if (M <= 0) {
         System.out.println("Klavyeden girilen M değeri 0' dan büyük olmalıdır! Program sonlandırıldı!");
         System.exit(0); // Programi sonlandirdim!
}
        if (N < M) {
          System.out.println("N değeri M' nin değerinden büyük olmalıdır. Program sonlandırıldı!");
          System.exit(0); // Programi sonlandirdim!
}
        if (N == M) {
          System.out.println("N değeri M' nin değerine eşit olursa herhangi bir balon patlatılmadan oyun son bulacakttır! Program sonlandırıldı!");
          System.exit(0); // // Programi sonlandirdim!
}
    //Girilen N ve M degerleri icin balonPozisyonuBul metodunu cagiriyorum.
    Uygulama.balonPozisyonuBul(N,M);
    
   
    }
}
