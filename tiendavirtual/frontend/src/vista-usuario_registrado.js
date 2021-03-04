import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-usuario_registrado`
 *
 * VistaUsuario_registrado element.
 *
 * @customElement
 * @polymer
 */
class VistaUsuario_registrado extends PolymerElement {

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
        return 'vista-usuario_registrado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaUsuario_registrado.is, VistaUsuario_registrado);
