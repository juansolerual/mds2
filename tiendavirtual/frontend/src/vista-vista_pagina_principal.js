import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-vista_pagina_principal`
 *
 * VistaVista_pagina_principal element.
 *
 * @customElement
 * @polymer
 */
class VistaVista_pagina_principal extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
        `;
    }

    static get is() {
        return 'vista-vista_pagina_principal';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVista_pagina_principal.is, VistaVista_pagina_principal);
