package com.tansen.study.dto.exception;//

public class BusinessException extends RuntimeException {
    private Object[] params;
    private long exCode;
    private String exDesc;

    /**
     * @deprecated
     */
    @Deprecated
    public BusinessException(long exCode, Throwable e) {
        super(String.valueOf(5000), e);
        this.setExCode(5000L);
    }

    public BusinessException(long exCode, Object... params) {
        super(String.valueOf(exCode));
        this.params = params;
        this.setExCode(exCode);
    }

    public BusinessException(String params) {
        super(String.valueOf(params));
    }

    public long getExCode() {
        return this.exCode;
    }

    public void setExCode(long exCode) {
        this.exCode = exCode;
    }

    public String getExDesc() {
        return this.exDesc;
    }

    public Object[] getParams() {
        return this.params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
