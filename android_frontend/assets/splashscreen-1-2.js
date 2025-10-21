(function () {
  // Apply fade-in animations to key elements if present
  const illustration = document.querySelector('.illustration');
  const headline = document.querySelector('.headline');
  const subtitle = document.querySelector('.subtitle');
  const cta = document.querySelector('.cta');

  [illustration, headline, subtitle, cta].forEach((el, idx) => {
    if (el) {
      el.classList.add('fade-in');
      if (idx > 0) el.classList.add(`delay-${idx}`);
    }
  });

  // Optional: handle CTA click (no navigation target specified in JSON)
  if (cta) {
    cta.addEventListener('click', () => {
      // Placeholder interaction; keep lightweight as per instruction
      cta.classList.add('active');
      setTimeout(() => cta.classList.remove('active'), 150);
    });
  }
})();
