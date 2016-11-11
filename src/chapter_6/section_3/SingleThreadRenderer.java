package chapter_6.section_3;

import java.util.ArrayList;
import java.util.List;

/**
 * SingleThreadRendere
 * <p/>
 * Rendering page elements sequentially
 * @author Brian Goetz and Tim Peierls
 *         The simplest approach is to process the HTML document sequentially. As text markup is encountered, render it into the image buffer; as
 *         image references are encountered, fetch the image over the network and draw it into the image buffer as well. This is easy to implement and
 *         requires touching each element of the input only once (it doesn't even require buffering the document), but is likely to annoy the user,
 *         who may have to wait a long time before all the text is rendered.
 *
 *         A less annoying but still sequential approach involves rendering the text elements first, leaving rectangular placeholders for the images,
 *         and after completing the initial pass on the document, going back and downloading the images and drawing them into the associated
 *         placeholder. This approach is shown in SingleThreadRenderer
 *         
 *         Downloading an image mostly involves waiting for I/O to complete, and during this time the CPU does little work. So the sequential approach
 *         may underutilize the CPU, and also makes the user wait longer than necessary to see the finished page. We can achieve better utilization
 *         and responsiveness by breaking the problem into independent tasks that can execute concurrently.
 */
public abstract class SingleThreadRenderer {

    void renderPage(CharSequence source) {
        renderText(source);
        List<ImageData> imageData = new ArrayList<ImageData>();
        for (ImageInfo imageInfo : scanForImageInfo(source))
            imageData.add(imageInfo.downloadImage());
        for (ImageData data : imageData)
            renderImage(data);
    }

    interface ImageData {

    }

    interface ImageInfo {

        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
