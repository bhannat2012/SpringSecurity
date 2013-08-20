package com.enums

import org.springframework.dao.DataIntegrityViolationException

class ItemTypeEnumController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [itemTypeEnumInstanceList: ItemTypeEnum.list(params), itemTypeEnumInstanceTotal: ItemTypeEnum.count()]
    }

    def create() {
        [itemTypeEnumInstance: new ItemTypeEnum(params)]
    }

    def save() {
        def itemTypeEnumInstance = new ItemTypeEnum(params)
        if (!itemTypeEnumInstance.save(flush: true)) {
            render(view: "create", model: [itemTypeEnumInstance: itemTypeEnumInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), itemTypeEnumInstance.id])
        redirect(action: "show", id: itemTypeEnumInstance.id)
    }

    def show(Long id) {
        def itemTypeEnumInstance = ItemTypeEnum.get(id)
        if (!itemTypeEnumInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), id])
            redirect(action: "list")
            return
        }

        [itemTypeEnumInstance: itemTypeEnumInstance]
    }

    def edit(Long id) {
        def itemTypeEnumInstance = ItemTypeEnum.get(id)
        if (!itemTypeEnumInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), id])
            redirect(action: "list")
            return
        }

        [itemTypeEnumInstance: itemTypeEnumInstance]
    }

    def update(Long id, Long version) {
        def itemTypeEnumInstance = ItemTypeEnum.get(id)
        if (!itemTypeEnumInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (itemTypeEnumInstance.version > version) {
                itemTypeEnumInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum')] as Object[],
                          "Another user has updated this ItemTypeEnum while you were editing")
                render(view: "edit", model: [itemTypeEnumInstance: itemTypeEnumInstance])
                return
            }
        }

        itemTypeEnumInstance.properties = params

        if (!itemTypeEnumInstance.save(flush: true)) {
            render(view: "edit", model: [itemTypeEnumInstance: itemTypeEnumInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), itemTypeEnumInstance.id])
        redirect(action: "show", id: itemTypeEnumInstance.id)
    }

    def delete(Long id) {
        def itemTypeEnumInstance = ItemTypeEnum.get(id)
        if (!itemTypeEnumInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), id])
            redirect(action: "list")
            return
        }

        try {
            itemTypeEnumInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum'), id])
            redirect(action: "show", id: id)
        }
    }
}
