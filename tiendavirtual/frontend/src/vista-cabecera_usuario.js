import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-cabecera_usuario_registrado`
 *
 * VistaCabecera_usuario_registrado element.
 *
 * @customElement
 * @polymer
 */
class VistaCabecera_usuario_registrado extends PolymerElement {

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
        return 'vista-cabecera_usuario_registrado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCabecera_usuario_registrado.is, VistaCabecera_usuario_registrado);
