package com.dieson.green.pojo;

public class Models {
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column models.id
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	private Integer id;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column models.model_name
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	private String modelName;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column models.model_user_id
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	private Integer modelProjectId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column models.status
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	private Boolean status;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column models.id
	 *
	 * @return the value of models.id
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column models.id
	 *
	 * @param id
	 *            the value for models.id
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column models.model_name
	 *
	 * @return the value of models.model_name
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column models.model_name
	 *
	 * @param modelName
	 *            the value for models.model_name
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName == null ? null : modelName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column models.status
	 *
	 * @return the value of models.status
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column models.status
	 *
	 * @param status
	 *            the value for models.status
	 *
	 * @mbg.generated Mon Jul 09 15:06:28 CST 2018
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the modelProjectId
	 */
	public Integer getModelProjectId() {
		return modelProjectId;
	}

	/**
	 * @param modelProjectId
	 *            the modelProjectId to set
	 */
	public void setModelProjectId(Integer modelProjectId) {
		this.modelProjectId = modelProjectId;
	}
}