package com.example.SupplierDemoAPI.supplier;

public class SupplierBankDetails {

    private String bankName;
    private String bankHolderName;
    private Long branchCode;
    private Long accountNumber;

    public SupplierBankDetails(String bankName, String bankHolderName, Long branchCode, Long accountNumber) {
        this.bankName = bankName;
        this.bankHolderName = bankHolderName;
        this.branchCode = branchCode;
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankHolderName() {
        return bankHolderName;
    }

    public void setBankHolderName(String bankHolderName) {
        this.bankHolderName = bankHolderName;
    }

    public Long getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Long branchCode) {
        this.branchCode = branchCode;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
