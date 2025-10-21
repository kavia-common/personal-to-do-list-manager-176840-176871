Splashscreen (screen_1:2) implementation notes

Purpose
- This document explains how the provided screen_1:2.json was mapped into HTML/CSS for pixel-approximate parity with the Figma design.

Canvas and coordinates
- Root frame: 430 x 932 pixels (from JSON dimensions).
- The HTML root (#splash-root) is fixed to 430x932 to preserve 1:1 mapping.
- Absolute positioning is used for elements requiring exact placement.
- For assets with an `imagePath` in the JSON, the image is referenced exactly via `/assets/figmaimages/<name>.<ext>` as required.

Status bar
- JSON “notification” frame (380x22) is horizontally centered at the top with specific icons:
  - WiFi: /assets/figmaimages/figma_image_1_10.svg
  - Signal: /assets/figmaimages/figma_image_1_14.svg
  - Battery: /assets/figmaimages/figma_image_1_12.svg
- Time text “9:30 PM” is included as live text (not image).

Illustration group
- JSON group “undraw_done_checking_re_6vyx 1” is represented with the subset of vector nodes that include an `imagePath`.
- Vectors without `imagePath` are omitted (they are shapes/paths not exported as images).
- Each vector placed with translated offsets relative to the 254x194 frame, per JSON widths/heights.

Text
- “Gets things with TODs” (typo_10) and the paragraph (typo_11) are added as semantic HTML text; font sizes chosen to match overall visual density.

Button
- “Get Started” rectangle + label mapped to a <button> with exact 380x60 size and centered horizontally.
- Color approximates style_11 per design; radius and shadow applied for parity.

Accessibility
- Images have alt text where meaningful; decorative vectors use empty alt.
- Tab focus and keyboard operation supported for CTA.

Preview
- Open assets/index.html or assets/splashscreen-1-2.html directly in a browser to validate against the provided PNG.

Scope
- These assets are standalone for design parity and are not wired into the Android runtime.
- Do not rename or move files; asset paths must remain as in the Figma JSON.
