import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-vista_centro_de_mensajes_administrador`
 *
 * VistaVista_centro_de_mensajes_administrador element.
 *
 * @customElement
 * @polymer
 */
class VistaVista_centro_de_mensajes_administrador extends PolymerElement {

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
        return 'vista-vista_centro_de_mensajes_administrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVista_centro_de_mensajes_administrador.is, VistaVista_centro_de_mensajes_administrador);
