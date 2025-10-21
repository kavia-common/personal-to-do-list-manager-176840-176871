Splashscreen (screen_1:2) Pixel Checklist

Canvas
- Root #splash-root: 430 x 932 px.

Status bar (notification)
- Container: width 380 px; height 22 px; centered at top.
- Time text: “9:30 PM”, font ~14 px, weight ~600.
- Icons:
  - WiFi: 21.19 x 14.83 px → /assets/figmaimages/figma_image_1_10.svg
  - Signal: 19.60 x 16.95 px → /assets/figmaimages/figma_image_1_14.svg
  - Battery: 21.19 x 10.60 px → /assets/figmaimages/figma_image_1_12.svg

Illustration
- Illustration frame: 254 x 194 px; placed around vertical mid.
- Vector subset positioned per JSON dimensions (see CSS classes .v-1-56 … .v-1-97).
- All referenced vectors use exact JSON imagePath (under /assets/figmaimages/).

Text
- Headline: “Gets things with TODs” width 201 px; centered; font ~22 px bold.
- Paragraph: width 203 px; multi-line; font ~12.5 px; line height ~20 px; centered.

CTA button
- Size: 380 x 60 px; horizontally centered; rounded corners (~12 px radius).
- Label: “Get Started”; centered vertically.
- Color: primary teal per design; white label; subtle shadow.

Shapes
- Two top ellipses, 200 x 200 px each; soft teal with 0.5 opacity; decorative.

Animation
- Fade-in from 0 to 1 over ~700 ms for illustration, headline, paragraph, and CTA.

Accessibility
- Status icons have alt text; decorative vectors have empty alt.
- Offscreen description #splash-desc describes layout for screen readers.

Validation
- Open assets/index.html or splashscreen-1-2.html to compare against attachments/screen_1-2.png.
