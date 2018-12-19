package com.iofs.loanmanagementsystem.utils.queue;

import com.iofs.loanmanagementsystem.utils.model.IofsLmsMessage;

public interface IofsListener {

	 public void processMessage(IofsLmsMessage message) throws Exception;
}
