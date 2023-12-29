package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Help {
	
	public static void butonYazi() {
		UIManager.put("OptionPane.cancelButtonText","İptal");
		UIManager.put("OptionPane.yesButtonText","Evet");
		UIManager.put("OptionPane.noButtonText","Hayır");
		UIManager.put("OptionPane.okButtonText","Tamam");
	}
	
	
    public static void ShowMsg(String str) {
    	
    	String msg;
    	butonYazi();
    	
    	switch(str) {
    	case "fill":
    		msg="Lütfen Boş Alanlari Doldurunuz!";
    		break;
    	case "hatali":
    		msg="Hatalı Giriş";
    		break;
    	case "ekle":
    		msg="Ekleme Başarılı";
    		break;
    	case "sil":
    		msg="Kullanıcı Silindi";
    		break;
    	case "bakiyeyetersiz":
    		msg="Bakiyeniz Yetersiz";
    		break;
    	case "borcyok":
    		msg="Borcunuz Bulunmamaktadır";
    		break;
    	case "odemebasarili":
    		msg="Ödeme İşlemi Başarılı";
    		break;
    	default:
    		msg=str;
    	}
    	JOptionPane.showMessageDialog(null, msg,"",JOptionPane.INFORMATION_MESSAGE);
    }
      public static boolean confirm(String str) {
    	  butonYazi();
    	  String msg;
    	  switch(str) {
    	  case "evet":
    		  msg = "Seçili Kullanıcı Silinsinmi?";
    		  break;
    		  default:
    			msg= str;  
    	  }
    	  int sonuc = JOptionPane.showConfirmDialog(null, msg,"",JOptionPane.YES_NO_OPTION);
    	  if(sonuc==0) 
    		  return true;
    	  else
    		  return false;
    	  
      }
}
