package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.xueli.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-08-06 15:10:56
 */
public class ZhimaCreditXueliGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6688517685286842541L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 院校名称
	 */
	@ApiField("college_name")
	private String collegeName;

	/** 
	 * 学历类别：普通，研究生，成人，高等教育自学考试，网络教育，开放教育，不详
	 */
	@ApiField("education_category")
	private String educationCategory;

	/** 
	 * 学历层次：博士研究生、硕士研究生、本科、专科、成人。
	 */
	@ApiField("education_degree")
	private String educationDegree;

	/** 
	 * 是否有学历。有，返回true，无，返回false
	 */
	@ApiField("exist")
	private Boolean exist;

	/** 
	 * 毕业日期
	 */
	@ApiField("graduate_year")
	private String graduateYear;

	/** 
	 * 专业名称
	 */
	@ApiField("major_name")
	private String majorName;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeName( ) {
		return this.collegeName;
	}

	public void setEducationCategory(String educationCategory) {
		this.educationCategory = educationCategory;
	}
	public String getEducationCategory( ) {
		return this.educationCategory;
	}

	public void setEducationDegree(String educationDegree) {
		this.educationDegree = educationDegree;
	}
	public String getEducationDegree( ) {
		return this.educationDegree;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}
	public Boolean getExist( ) {
		return this.exist;
	}

	public void setGraduateYear(String graduateYear) {
		this.graduateYear = graduateYear;
	}
	public String getGraduateYear( ) {
		return this.graduateYear;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajorName( ) {
		return this.majorName;
	}

}
