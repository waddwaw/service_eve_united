package com.Eveunited.db;

public class DBAccessException extends Exception {

	private static final long serialVersionUID = 1L;

	protected Throwable throwable;

	/**
	 * ���췽��
	 * 
	 * @param message
	 */
	public DBAccessException(String message) {
		super(message);

	}

	/**
	 * ���췽��
	 * 
	 * @param message
	 * @param throwable
	 */
	public DBAccessException(String message, Throwable throwable) {
		super(message);
		this.throwable = throwable;
	}

	/**
	 * ���صײ��쳣ԭ��
	 * 
	 * @return Throwable
	 */
	public Throwable getCause() {
		return throwable;
	}

}