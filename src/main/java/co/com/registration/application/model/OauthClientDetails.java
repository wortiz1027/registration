package co.com.registration.application.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "OAUTH_CLIENT_DETAILS", catalog = "", schema = "APPLICATION", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CLIENT_ID"})})
@Proxy(lazy=false)
@NamedQueries({
    @NamedQuery(name = "OauthClientDetails.findAll", query = "SELECT o FROM OauthClientDetails o"),
    @NamedQuery(name = "OauthClientDetails.findByOid", query = "SELECT o FROM OauthClientDetails o WHERE o.oid = :oid"),
    @NamedQuery(name = "OauthClientDetails.findByClientId", query = "SELECT o FROM OauthClientDetails o WHERE o.clientId = :clientId"),
    @NamedQuery(name = "OauthClientDetails.findByClientName", query = "SELECT o FROM OauthClientDetails o WHERE o.clientName = :clientName"),
    @NamedQuery(name = "OauthClientDetails.findByResourceIds", query = "SELECT o FROM OauthClientDetails o WHERE o.resourceIds = :resourceIds"),
    @NamedQuery(name = "OauthClientDetails.findByClientSecret", query = "SELECT o FROM OauthClientDetails o WHERE o.clientSecret = :clientSecret"),
    @NamedQuery(name = "OauthClientDetails.findByScope", query = "SELECT o FROM OauthClientDetails o WHERE o.scope = :scope"),
    @NamedQuery(name = "OauthClientDetails.findByAuthorizedGrantTypes", query = "SELECT o FROM OauthClientDetails o WHERE o.authorizedGrantTypes = :authorizedGrantTypes"),
    @NamedQuery(name = "OauthClientDetails.findByWebServerRedirectUri", query = "SELECT o FROM OauthClientDetails o WHERE o.webServerRedirectUri = :webServerRedirectUri"),
    @NamedQuery(name = "OauthClientDetails.findByAuthorities", query = "SELECT o FROM OauthClientDetails o WHERE o.authorities = :authorities"),
    @NamedQuery(name = "OauthClientDetails.findByAccessTokenValidity", query = "SELECT o FROM OauthClientDetails o WHERE o.accessTokenValidity = :accessTokenValidity"),
    @NamedQuery(name = "OauthClientDetails.findByRefreshTokenValidity", query = "SELECT o FROM OauthClientDetails o WHERE o.refreshTokenValidity = :refreshTokenValidity"),
    @NamedQuery(name = "OauthClientDetails.findByAdditionalInformation", query = "SELECT o FROM OauthClientDetails o WHERE o.additionalInformation = :additionalInformation"),
    @NamedQuery(name = "OauthClientDetails.findByAutoapprove", query = "SELECT o FROM OauthClientDetails o WHERE o.autoapprove = :autoapprove")})
public class OauthClientDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OID", nullable = false, precision = 0, scale = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OAUTH_SEQ")
    @SequenceGenerator(name = "OAUTH_SEQ", sequenceName = "SQ_OAUTH", allocationSize = 1)
    private BigDecimal oid;
    @Size(max = 255)
    @Column(name = "CLIENT_ID", length = 255)
    private String clientId;
    @Size(max = 255)
    @Column(name = "CLIENT_NAME", length = 255)
    private String clientName;
    @Size(max = 255)
    @Column(name = "RESOURCE_IDS", length = 255)
    private String resourceIds;
    @Size(max = 255)
    @Column(name = "CLIENT_SECRET", length = 255)
    private String clientSecret;
    @Size(max = 255)
    @Column(name = "SCOPE", length = 255)
    private String scope;
    @Size(max = 255)
    @Column(name = "AUTHORIZED_GRANT_TYPES", length = 255)
    private String authorizedGrantTypes;
    @Size(max = 255)
    @Column(name = "WEB_SERVER_REDIRECT_URI", length = 255)
    private String webServerRedirectUri;
    @Size(max = 255)
    @Column(name = "AUTHORITIES", length = 255)
    private String authorities;
    @Column(name = "ACCESS_TOKEN_VALIDITY")
    private Long accessTokenValidity;
    @Column(name = "REFRESH_TOKEN_VALIDITY")
    private Long refreshTokenValidity;
    @Size(max = 2000)
    @Column(name = "ADDITIONAL_INFORMATION", length = 2000)
    private String additionalInformation;
    @Size(max = 255)
    @Column(name = "AUTOAPPROVE", length = 255)
    private String autoapprove;

    public OauthClientDetails() {
    }

    public OauthClientDetails(BigDecimal oid) {
        this.oid = oid;
    }

    public BigDecimal getOid() {
        return oid;
    }

    public void setOid(BigDecimal oid) {
        this.oid = oid;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Long getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Long accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Long getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Long refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthClientDetails)) {
            return false;
        }
        OauthClientDetails other = (OauthClientDetails) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.OauthClientDetails[ oid=" + oid + " ]";
    }
    
}
