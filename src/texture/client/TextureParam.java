package texture.client;

import java.util.List;

import texture.domain.Material;

public class TextureParam {

	public TextureParam(){
		
	}
	
	public TextureParam(String zcz, String luhao, Double zc, Double zsi,
			Double zmn, Double zp, Double zs, Double zcr, Double zni,
			Double zmo, Double zcu, Double zv, Double zal, Double znb,
			Double zw, Double zzn, Double zti, Double zzr, Double zn,
			Double zta1, Double zfe, Double zb, Double zsn, Double zsb,
			Double zas, Double co,Double zzfe,Double zca,Double zh,Double zo,
			Double zta,Double zts, Double zys, Double ze,
			Double zr, Double zhb, String zj, String zj1, String zj2,
			String vt, String pt, String mt, String rt, String ut,
			String temper1, String time1, String temper2, String time2,
			String temper3, String time3, String temper4, String time4,
			String cj, String cj_avg,
			String cj_min, String furn1,String furn2,String furn3,String pren,String ce,String userAccount,String supplier_code,List<Material> materials,
			Double gts,Double gys,Double ge,Double gr,String zgwls) {
		super();
		this.zcz = zcz;
		this.luhao = luhao;
		this.zc = zc;
		this.zsi = zsi;
		this.zmn = zmn;
		this.zp = zp;
		this.zs = zs;
		this.zcr = zcr;
		this.zni = zni;
		this.zmo = zmo;
		this.zcu = zcu;
		this.zv = zv;
		this.zal = zal;
		this.znb = znb;
		this.zw = zw;
		this.zzn = zzn;
		this.zti = zti;
		this.zzr = zzr;
		this.zn = zn;
		this.zta1 = zta1;
		this.zfe = zfe;
		this.zb = zb;
		this.zsn = zsn;
		this.zsb = zsb;
		this.zas = zas;
		this.co = co;
		this.zzfe=zzfe;
		this.zca=zca;
		this.zh=zh;
		this.zo=zo;
		this.zta=zta;
		this.zts = zts;
		this.zys = zys;
		this.ze = ze;
		this.zr = zr;
		this.zhb = zhb;
		this.zj = zj;
		this.zj1 = zj1;
		this.zj2 = zj2;
		this.vt = vt;
		this.pt = pt;
		this.mt = mt;
		this.rt = rt;
		this.ut = ut;
		this.temper1 = temper1;
		this.time1 = time1;
		this.temper2 = temper2;
		this.time2 = time2;
		this.temper3 = temper3;
		this.time3 = time3;
		this.temper4 = temper4;
		this.time4 = time4;

		this.cj = cj;
		this.cj_avg = cj_avg;
		this.cj_min = cj_min;
		this.furn1 = furn1;
		this.furn2 = furn2;
		this.furn3 = furn3;
		this.pren =pren;
		this.ce =ce;
		this.userAccount = userAccount;
		this.supplier_code=supplier_code;
		this.materials=materials;
		this.gts=gts;
		this.gys=gys;
		this.ge=ge;
		this.gr=gr;
		this.zgwls=zgwls;
	}

	/**材质**/
	private String zcz;
	/**炉号**/
	private String luhao;
	/**碳含量**/
	private Double zc;
	/**硅含量**/
	private Double zsi;
	/**锰含量**/
	private Double zmn;
	/**磷含量**/
	private Double zp;
	/**硫含量**/
	private Double zs;
	/**铬含量**/
	private Double zcr;
	/**镍含量**/
	private Double zni;
	/**钼含量**/
	private Double zmo;
	/**铜含量**/
	private Double zcu;
	/**钒含量**/
	private Double zv;
	/**铝含量**/
	private Double zal;
	/**铌含量**/
	private Double znb;
	/**钨含量**/
	private Double zw;
	/**锌含量**/
	private Double zzn;
	/**钛含量**/
	private Double zti;
	/**锆含量**/
	private Double zzr;
	/**氮含量**/
	private Double zn;
	/**Cb/Nb+Ta**/
	private Double zta1;
	/**铁含量**/
	private Double zfe;
	/**硼含量**/
	private Double zb;
	/**锡含量**/
	private Double zsn;
	/**锑含量**/
	private Double zsb;
	/**砷含量**/
	private Double zas;
	/**钴含量**/
	private Double co;
	/**铁素**/
	private Double zzfe;
	/**钙元素**/
	private Double zca;
	/**氢元素**/
	private Double zh;
	/**氧元素**/
	private Double zo;
	/**铊元素**/
	private Double zta;
	/**拉伸**/
	private Double zts;
	/**屈服**/
	private Double zys;
	/**延伸率**/
	private Double ze;
	/**截面收缩率**/
	private Double zr;
	/**硬度**/
	private Double zhb;
	/**冲击值**/
	private String zj;
	/**冲击值1**/
	private String zj1;
	/**冲击值2**/
	private String zj2;
	/**高温拉伸**/
	private Double gts;
	/**高温屈服**/
	private Double gys;
	/**高温延伸率**/
	private Double ge;
	/**高温截面收缩率**/
	private Double gr;
	/**高温拉伸温度**/
	private String zgwls;
	/**vt**/
	private String vt;
	/**pt**/
	private String pt;
	/**mt**/
	private String mt;
	/**rt**/
	private String rt;
	/**ut**/
	private String ut;
	/**温度1**/
	private String temper1;
	/**保持时间1**/
	private String time1;
	/**温度2**/
	private String temper2;
	/**保持时间2**/
	private String time2;
	/**温度3**/
	private String temper3;
	/**保持时间3**/
	private String time3;
	/**温度4**/
	private String temper4;
	/**保持时间4**/
	private String time4;

	/**特殊冲击温度**/
	private String cj;
	/**特殊冲击接受平均值 **/
	private String cj_avg;
	/**特殊冲击接受最小值 **/
	private String cj_min;
	/**炉子类型1**/
	private String furn1;
	/**炉子类型2**/
	private String furn2;
	/**炉子类型3**/
	private String furn3;
	/**pren值**/
	private String pren;
	/**碳当量，CE**/
	private String ce;
	/**传入用户账号**/
	private String userAccount;
	/**供应商代码**/
	private String supplier_code;
	/**物料清单--用于存放保证载荷信息**/
	private List<Material>materials;
	
	public String getPren() {
		return pren;
	}

	public void setPren(String pren) {
		this.pren = pren;
	}

	public String getZcz() {
		return zcz;
	}
	public void setZcz(String zcz) {
		this.zcz = zcz;
	}
	public String getLuhao() {
		return luhao;
	}
	public void setLuhao(String luhao) {
		this.luhao = luhao;
	}
	public Double getZc() {
		return zc;
	}
	public void setZc(Double zc) {
		this.zc = zc;
	}
	public Double getZsi() {
		return zsi;
	}
	public void setZsi(Double zsi) {
		this.zsi = zsi;
	}
	public Double getZmn() {
		return zmn;
	}
	public void setZmn(Double zmn) {
		this.zmn = zmn;
	}
	public Double getZp() {
		return zp;
	}
	public void setZp(Double zp) {
		this.zp = zp;
	}
	public Double getZs() {
		return zs;
	}
	public void setZs(Double zs) {
		this.zs = zs;
	}
	public Double getZcr() {
		return zcr;
	}
	public void setZcr(Double zcr) {
		this.zcr = zcr;
	}
	public Double getZni() {
		return zni;
	}
	public void setZni(Double zni) {
		this.zni = zni;
	}
	public Double getZmo() {
		return zmo;
	}
	public void setZmo(Double zmo) {
		this.zmo = zmo;
	}
	public Double getZcu() {
		return zcu;
	}
	public void setZcu(Double zcu) {
		this.zcu = zcu;
	}
	public Double getZv() {
		return zv;
	}
	public void setZv(Double zv) {
		this.zv = zv;
	}
	public Double getZal() {
		return zal;
	}
	public void setZal(Double zal) {
		this.zal = zal;
	}
	public Double getZnb() {
		return znb;
	}
	public void setZnb(Double znb) {
		this.znb = znb;
	}
	public Double getZw() {
		return zw;
	}
	public void setZw(Double zw) {
		this.zw = zw;
	}
	public Double getZzn() {
		return zzn;
	}
	public void setZzn(Double zzn) {
		this.zzn = zzn;
	}
	public Double getZti() {
		return zti;
	}
	public void setZti(Double zti) {
		this.zti = zti;
	}
	public Double getZzr() {
		return zzr;
	}
	public void setZzr(Double zzr) {
		this.zzr = zzr;
	}
	public Double getZn() {
		return zn;
	}
	public void setZn(Double zn) {
		this.zn = zn;
	}
	public Double getZta1() {
		return zta1;
	}
	public void setZta1(Double zta1) {
		this.zta1 = zta1;
	}
	public Double getZfe() {
		return zfe;
	}
	public void setZfe(Double zfe) {
		this.zfe = zfe;
	}
	public Double getZb() {
		return zb;
	}
	public void setZb(Double zb) {
		this.zb = zb;
	}
	public Double getZsn() {
		return zsn;
	}
	public void setZsn(Double zsn) {
		this.zsn = zsn;
	}
	public Double getZsb() {
		return zsb;
	}
	public void setZsb(Double zsb) {
		this.zsb = zsb;
	}
	public Double getZas() {
		return zas;
	}
	public void setZas(Double zas) {
		this.zas = zas;
	}
	public Double getCo() {
		return co;
	}
	public void setCo(Double co) {
		this.co = co;
	}
	public Double getZts() {
		return zts;
	}
	public void setZts(Double zts) {
		this.zts = zts;
	}
	public Double getZys() {
		return zys;
	}
	public void setZys(Double zys) {
		this.zys = zys;
	}
	public Double getZe() {
		return ze;
	}
	public void setZe(Double ze) {
		this.ze = ze;
	}
	public Double getZr() {
		return zr;
	}
	public void setZr(Double zr) {
		this.zr = zr;
	}
	public Double getZhb() {
		return zhb;
	}
	public void setZhb(Double zhb) {
		this.zhb = zhb;
	}
	
	public String getZj() {
		return zj;
	}

	public void setZj(String zj) {
		this.zj = zj;
	}

	public String getZj1() {
		return zj1;
	}

	public void setZj1(String zj1) {
		this.zj1 = zj1;
	}

	public String getZj2() {
		return zj2;
	}

	public void setZj2(String zj2) {
		this.zj2 = zj2;
	}

	public String getVt() {
		return vt;
	}
	public void setVt(String vt) {
		this.vt = vt;
	}
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public String getMt() {
		return mt;
	}
	public void setMt(String mt) {
		this.mt = mt;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getUt() {
		return ut;
	}
	public void setUt(String ut) {
		this.ut = ut;
	}
	public String getTemper1() {
		return temper1;
	}
	public void setTemper1(String temper1) {
		this.temper1 = temper1;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTemper2() {
		return temper2;
	}
	public void setTemper2(String temper2) {
		this.temper2 = temper2;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getTemper3() {
		return temper3;
	}
	public void setTemper3(String temper3) {
		this.temper3 = temper3;
	}
	public String getTime3() {
		return time3;
	}
	public void setTime3(String time3) {
		this.time3 = time3;
	}
	public String getTemper4() {
		return temper4;
	}
	public void setTemper4(String temper4) {
		this.temper4 = temper4;
	}
	public String getTime4() {
		return time4;
	}
	public void setTime4(String time4) {
		this.time4 = time4;
	}
	
	public String getCj() {
		return cj;
	}
	public void setCj(String cj) {
		this.cj = cj;
	}
	public String getCj_avg() {
		return cj_avg;
	}
	public void setCj_avg(String cj_avg) {
		this.cj_avg = cj_avg;
	}
	public String getCj_min() {
		return cj_min;
	}
	public void setCj_min(String cj_min) {
		this.cj_min = cj_min;
	}
	public String getFurn1() {
		return furn1;
	}
	public void setFurn1(String furn1) {
		this.furn1 = furn1;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getFurn2() {
		return furn2;
	}

	public void setFurn2(String furn2) {
		this.furn2 = furn2;
	}

	public String getFurn3() {
		return furn3;
	}

	public void setFurn3(String furn3) {
		this.furn3 = furn3;
	}

	public String getSupplier_code() {
		return supplier_code;
	}

	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Double getZzfe() {
		return zzfe;
	}

	public void setZzfe(Double zzfe) {
		this.zzfe = zzfe;
	}

	public Double getZca() {
		return zca;
	}

	public void setZca(Double zca) {
		this.zca = zca;
	}

	public Double getZh() {
		return zh;
	}

	public void setZh(Double zh) {
		this.zh = zh;
	}

	public Double getZo() {
		return zo;
	}

	public void setZo(Double zo) {
		this.zo = zo;
	}

	public Double getZta() {
		return zta;
	}

	public void setZta(Double zta) {
		this.zta = zta;
	}

	public String getCe() {
		return ce;
	}

	public void setCe(String ce) {
		this.ce = ce;
	}

	public Double getGts() {
		return gts;
	}

	public void setGts(Double gts) {
		this.gts = gts;
	}

	public Double getGys() {
		return gys;
	}

	public void setGys(Double gys) {
		this.gys = gys;
	}

	public Double getGe() {
		return ge;
	}

	public void setGe(Double ge) {
		this.ge = ge;
	}

	public Double getGr() {
		return gr;
	}

	public void setGr(Double gr) {
		this.gr = gr;
	}

	public String getZgwls() {
		return zgwls;
	}

	public void setZgwls(String zgwls) {
		this.zgwls = zgwls;
	}
	
	
	
	
}
