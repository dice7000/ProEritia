package net.dice7000.proeritia.util;

import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix4f;

public class ProEritiaUtil {
    public void renderVertex(
            VertexConsumer vc, Matrix4f mat,
            float vertX, float vertY, float vertZ, int r, int g, int b, int a, float uv1, float uv2, int overlayCoords, int light, float normal1, float normal2, float normal3

    ) {
        vc.vertex(mat, vertX, vertY, vertZ).color(r,g,b,a).uv(uv1,uv2).overlayCoords(overlayCoords).uv2(light).normal(normal1, normal2, normal3).endVertex();
    }
}
