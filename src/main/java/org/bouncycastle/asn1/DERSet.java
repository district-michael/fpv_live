package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class DERSet extends ASN1Set {
    private int bodyLength = -1;

    public DERSet() {
    }

    public DERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.bouncycastle.asn1.ASN1Set.<init>(org.bouncycastle.asn1.ASN1EncodableVector, boolean):void
     arg types: [org.bouncycastle.asn1.ASN1EncodableVector, int]
     candidates:
      org.bouncycastle.asn1.ASN1Set.<init>(org.bouncycastle.asn1.ASN1Encodable[], boolean):void
      org.bouncycastle.asn1.ASN1Set.<init>(org.bouncycastle.asn1.ASN1EncodableVector, boolean):void */
    public DERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, true);
    }

    DERSet(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        super(aSN1EncodableVector, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.bouncycastle.asn1.ASN1Set.<init>(org.bouncycastle.asn1.ASN1Encodable[], boolean):void
     arg types: [org.bouncycastle.asn1.ASN1Encodable[], int]
     candidates:
      org.bouncycastle.asn1.ASN1Set.<init>(org.bouncycastle.asn1.ASN1EncodableVector, boolean):void
      org.bouncycastle.asn1.ASN1Set.<init>(org.bouncycastle.asn1.ASN1Encodable[], boolean):void */
    public DERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, true);
    }

    private int getBodyLength() throws IOException {
        int i;
        if (this.bodyLength < 0) {
            int i2 = 0;
            Enumeration objects = getObjects();
            while (true) {
                i = i2;
                if (!objects.hasMoreElements()) {
                    break;
                }
                i2 = ((ASN1Encodable) objects.nextElement()).toASN1Primitive().toDERObject().encodedLength() + i;
            }
            this.bodyLength = i;
        }
        return this.bodyLength;
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        ASN1OutputStream dERSubStream = aSN1OutputStream.getDERSubStream();
        int bodyLength2 = getBodyLength();
        aSN1OutputStream.write(49);
        aSN1OutputStream.writeLength(bodyLength2);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            dERSubStream.writeObject((ASN1Encodable) objects.nextElement());
        }
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        int bodyLength2 = getBodyLength();
        return bodyLength2 + StreamUtil.calculateBodyLength(bodyLength2) + 1;
    }
}
