package com.iofs.loanmanagementsystem.utils.model;

public class IofsLmsMessage {

	long messageId;
	long loanApplicationId;
	boolean underWriterApproval;
	boolean riskApproval;
	boolean financeApproval;
	String reason;
	IofsLmsMessageState messageState;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public long getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(long loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public boolean isUnderWriterApproval() {
		return underWriterApproval;
	}

	public void setUnderWriterApproval(boolean underWriterApproval) {
		this.underWriterApproval = underWriterApproval;
	}

	public boolean isRiskApproval() {
		return riskApproval;
	}

	public void setRiskApproval(boolean riskApproval) {
		this.riskApproval = riskApproval;
	}

	public boolean isFinanceApproval() {
		return financeApproval;
	}

	public void setFinanceApproval(boolean financeApproval) {
		this.financeApproval = financeApproval;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public IofsLmsMessageState getMessageState() {
		return messageState;
	}

	public void setMessageState(IofsLmsMessageState messageState) {
		this.messageState = messageState;
	}
	
	
}
