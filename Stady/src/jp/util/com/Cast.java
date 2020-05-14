package jp.util.com;

import java.util.List;

import jp.bean.com.ResBean;

public class Cast {

	  @SuppressWarnings("unchecked")
	    public static List<ResBean> castList(Object object){
	        return (List<ResBean>)object;
	    }

}
